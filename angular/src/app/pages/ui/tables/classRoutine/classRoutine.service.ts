import { Injectable, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable, Subject, throwError } from 'rxjs';
import { tap, map, catchError } from 'rxjs/operators';
import { Classroutine } from './classRoutine.model';
import { data } from 'jquery';
const headerOption = {
    headers: new HttpHeaders({ 'content-type': 'application/json' })
  };

@Injectable({
    providedIn: 'root'
})

export class ClassroutineService implements OnInit{
    dtOptions: DataTables.Settings = {};

    dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/classroutine';
    currentClassroutine: Classroutine =  new Classroutine();

   
    private refreshNeeded = new Subject<void>();

  

    constructor(private  http: HttpClient) {
    }

    get refreshNeed(){
        return this.refreshNeeded;
      }


    ngOnInit(): void {
        this.getAllClassroutine();
  
        console.log("serrvice is callting on ngOnInit")
    }

    getAllClassroutine(): Observable<Classroutine[]> {
        return this.http.get<Classroutine[]>(this.dataUrl, headerOption);
          
      }

      deleteClassroutine(id: number): Observable<Classroutine> {
        return this.http.delete<Classroutine>(this.dataUrl + '/' +id, headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
      }
      createClassroutine(emp:Classroutine):Observable<Classroutine>{
        console.log("CreateEmployess");
        return this.http.post<Classroutine>(this.dataUrl,emp,headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
      }
      updateClassroutine(emp:Classroutine):Observable<Classroutine>{
        console.log("UpdateEmployess");
        return this.http.put<Classroutine>(this.dataUrl+'/'+emp.routineid,emp,headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
    
      }
}
