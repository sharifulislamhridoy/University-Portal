import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, Subject } from 'rxjs';


import { tap } from 'rxjs/operators';
import { Studentaccount } from './Studentaccount.model';
import { AssignCourse } from '../assignCourse/AssignCourse.model';

const headerOption = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})

export class StudentaccountService {

  dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/studentaccount';
  currentStudentaccount: Studentaccount = new Studentaccount();

  constructor(private http: HttpClient) {

  }

  private refreshNeeded = new Subject<void>();




  getAllStudentaccount(): Observable<Studentaccount[]> {
    return this.http.get<Studentaccount[]>(this.dataUrl, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }
  getCoursesOneStudentById(name: string): Observable<Studentaccount[]> {
    return this.http.get<Studentaccount[]>(this.dataUrl + '/getById/' + name, headerOption);
  }

  getCoursesById(name: string): Observable<AssignCourse[]> {
    return this.http.get<AssignCourse[]>(this.dataUrl + '/getById/' + name, headerOption);
  }
  createStudentaccount(crs: Studentaccount): Observable<Studentaccount> {
    console.log("CreateStudentaccount");
    return this.http.post<Studentaccount>(this.dataUrl, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  deleteStudentaccount(id: number): Observable<Studentaccount> {
    return this.http.delete<Studentaccount>(this.dataUrl + '/' + id, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  updateStudentaccount(crs: Studentaccount): Observable<Studentaccount> {
    console.log("UpdateStudentaccount");
    return this.http.put<Studentaccount>(this.dataUrl + '/' + crs.id, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }

}
