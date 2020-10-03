import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, Subject } from 'rxjs';

import { Courses } from './courses.model';
import { tap } from 'rxjs/operators';

const headerOption = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})

export class CoursesbasicService {
  dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/courses';
  currentCourses: Courses = new Courses();

  constructor(private http: HttpClient) {

  }

  private refreshNeeded = new Subject<void>();

  get refreshNeed(){
    return this.refreshNeeded;
  }

  getAllCourses(): Observable<Courses[]> {
    return this.http.get<Courses[]>(this.dataUrl, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }
  createCourses(crs: Courses): Observable<Courses> {
    console.log("CreateEmployess");
    return this.http.post<Courses>(this.dataUrl, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  deleteCourses(id: number): Observable<Courses> {
    return this.http.delete<Courses>(this.dataUrl + '/' + id, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }
  getAllCoursesByName(name:string): Observable<Courses[]> {
    return this.http.get<Courses[]>(this.dataUrl+'/getByName/'+name, headerOption);
      
  }

  updateCourses(crs: Courses): Observable<Courses> {
    console.log("UpdateCourses");
    return this.http.put<Courses>(this.dataUrl + '/' + crs.id, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }

}
