import { Injectable, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable, Subject, throwError } from 'rxjs';
import { tap, map, catchError } from 'rxjs/operators';
import { ShowAttandance } from './showAttandance.model';

const headerOption = {
    headers: new HttpHeaders({ 'content-type': 'application/json' })
  };

@Injectable({
    providedIn: 'root'
})

export class ShowAttandanceService implements OnInit{
    dtOptions: DataTables.Settings = {};

    dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/attandance';
    currentShowAttandance: ShowAttandance =  new ShowAttandance();

   
    private refreshNeeded = new Subject<void>();

  

    constructor(private  http: HttpClient) {
    }

    get refreshNeed(){
        return this.refreshNeeded;
      }


    ngOnInit(): void {
        this.getAllShowAttandance();
  
        console.log("serrvice is callting on ngOnInit")
    }

    getAllShowAttandance(): Observable<ShowAttandance[]> {
        return this.http.get<ShowAttandance[]>(this.dataUrl, headerOption);
          
      }

      deleteShowAttandance(id: number): Observable<ShowAttandance> {
        return this.http.delete<ShowAttandance>(this.dataUrl + '/' +id, headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
      }
      getCoursesById(name:string): Observable<ShowAttandance[]> {
        return this.http.get<ShowAttandance[]>(this.dataUrl+'/getById/'+name, headerOption);
          
      }
      createShowAttandance(emp:ShowAttandance):Observable<ShowAttandance>{
        console.log("CreateEmployess");
        return this.http.post<ShowAttandance>(this.dataUrl,emp,headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
      }
      updateShowAttandance(emp:ShowAttandance):Observable<ShowAttandance>{
        console.log("UpdateEmployess");
        return this.http.put<ShowAttandance>(this.dataUrl+'/'+emp.id,emp,headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
    
      }
}
