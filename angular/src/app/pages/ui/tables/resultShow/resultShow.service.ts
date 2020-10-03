import { Injectable, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable, Subject, throwError } from 'rxjs';
import { tap, map, catchError } from 'rxjs/operators';
import { Result } from './resultShow.model';
const headerOption = {
    headers: new HttpHeaders({ 'content-type': 'application/json' })
  };

@Injectable({
    providedIn: 'root'
})

export class ResultService implements OnInit{
    dtOptions: DataTables.Settings = {};

    dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/result';
    currentResult: Result =  new Result();

   
    private refreshNeeded = new Subject<void>();

  

    constructor(private  http: HttpClient) {
    }

    get refreshNeed(){
        return this.refreshNeeded;
      }


    ngOnInit(): void {
        this.getAllResult();
  
        console.log("serrvice is callting on ngOnInit")
    }

    getAllResult(): Observable<Result[]> {
        return this.http.get<Result[]>(this.dataUrl, headerOption);
          
      }

      deleteResult(id: number): Observable<Result> {
        return this.http.delete<Result>(this.dataUrl + '/' +id, headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
      }
      getCoursesById(name:string): Observable<Result[]> {
        return this.http.get<Result[]>(this.dataUrl+'/getById/'+name, headerOption);
          
      }
      createResult(emp:Result):Observable<Result>{
        console.log("CreateEmployess");
        return this.http.post<Result>(this.dataUrl,emp,headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
      }
      updateResult(emp:Result):Observable<Result>{
        console.log("UpdateEmployess");
        return this.http.put<Result>(this.dataUrl+'/'+emp.id,emp,headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
    
      }
}
