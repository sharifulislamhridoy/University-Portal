import { Injectable, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable, Subject } from 'rxjs';
import { tap } from 'rxjs/operators';
import { University } from './university.model';


const headerOption = {
    headers: new HttpHeaders({ 'content-type': 'application/json' })
  };

@Injectable({
    providedIn: 'root'
})

export class UniversityService implements OnInit{
    dtOptions: DataTables.Settings = {};

    dataUrl = 'http://localhost:8084/UniversityProtal/api/s1/University';
    currentUniversity:University =  new University();


    private refreshNeeded = new Subject<void>();

  

    constructor(private  http: HttpClient) {
    }

    get refreshNeed(){
        return this.refreshNeeded;
      }


    ngOnInit(): void {
        this.getAllUniversity();
  
        console.log("serrvice is callting on ngOnInit")
    }

    getAllUniversity(): Observable<University[]> {
        return this.http.get<University[]>(this.dataUrl, headerOption);
          
      }
      deleteUniversity(id: number): Observable<University> {
        return this.http.delete<University>(this.dataUrl + '/' +id, headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
            this.ngOnInit();
          })
        );
      }
      createUniversity(emp:University):Observable<University>{
        console.log("CreateUniversity");
        return this.http.post<University>(this.dataUrl,emp,headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
            this.ngOnInit();
          })
        );
      }
      updateUniversity(std:University):Observable<University>{
        console.log("UpdateUniversity");
        return this.http.put<University>(this.dataUrl+'/'+std.id,std,headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
    
      }
}
