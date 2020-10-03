import { Injectable, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Professors } from './professors';
import { Observable, Subject } from 'rxjs';
import { tap } from 'rxjs/operators';
const headerOption = {
    headers: new HttpHeaders({ 'content-type': 'application/json' })
  };

@Injectable({
    providedIn: 'root'
})

export class ProfessorsService implements OnInit{
    dtOptions: DataTables.Settings = {};

    dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/professors';
    currentProfesors: Professors =  new Professors();


    private refreshNeeded = new Subject<void>();

  

    constructor(private  http: HttpClient) {
    }

    get refreshNeed(){
        return this.refreshNeeded;
      }


    ngOnInit(): void {
        this.getAllProfessors();
  
        console.log("serrvice is callting on ngOnInit")
    }

    getAllProfessors(): Observable<Professors[]> {
        return this.http.get<Professors[]>(this.dataUrl, headerOption);
          
      }

      getAllProfessorsByName(name:string): Observable<Professors[]> {
        return this.http.get<Professors[]>(this.dataUrl+'/getByName/'+name, headerOption);
          
      }
      deleteProfessors(id: number): Observable<Professors> {
        return this.http.delete<Professors>(this.dataUrl + '/' +id, headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
      }
      createProfessors(emp:Professors):Observable<Professors>{
        console.log("CreateEmployess");
        return this.http.post<Professors>(this.dataUrl,emp,headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
      }
      updateProfessors(emp:Professors):Observable<Professors>{
        console.log("UpdateEmployess");
        return this.http.put<Professors>(this.dataUrl+'/'+emp.id,emp,headerOption).pipe(
          tap(()=>{
            this.refreshNeeded.next();
          })
        );
    
      }
}
