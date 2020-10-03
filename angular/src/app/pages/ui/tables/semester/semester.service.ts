import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, Subject } from 'rxjs';


import { tap } from 'rxjs/operators';
import { Semester } from './semester.model';

const headerOption = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})

export class SemesterService {
  dataUrl = 'http://localhost:8084/UniversityProtal/api/s1/semester';
  currentSemester: Semester = new Semester();
  get refreshNeed(){
    return this.refreshNeeded;
  }

  constructor(private http: HttpClient) {

  }

  private refreshNeeded = new Subject<void>();

  getAllSemester(): Observable<Semester[]> {
    return this.http.get<Semester[]>(this.dataUrl, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }
  createSemester(crs: Semester): Observable<Semester> {
    console.log("CreateNotice");
    return this.http.post<Semester>(this.dataUrl, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  deleteSemester(id: number): Observable<Semester> {
    return this.http.delete<Semester>(this.dataUrl + '/' + id, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  updateSemester(crs: Semester): Observable<Semester> {
    console.log("UpdateNotice");
    return this.http.put<Semester>(this.dataUrl + '/' + crs.semesterId, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }

}
