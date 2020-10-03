import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, Subject } from 'rxjs';

import { AssignCourse } from './AssignCourse.model';
import { tap } from 'rxjs/operators';
import { Courses } from '../Courses/courses.model';

const headerOption = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})

export class assignAssignCoursSeervice {
  dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/assigncourses';
  currentAssignCourse: AssignCourse = new AssignCourse();

  constructor(private http: HttpClient) {

  }

  private refreshNeeded = new Subject<void>();

  getAllAssignCourse(): Observable<AssignCourse[]> {
    return this.http.get<AssignCourse[]>(this.dataUrl, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }
  getCoursesByName(name:string): Observable<AssignCourse[]> {
    return this.http.get<AssignCourse[]>(this.dataUrl+'/getByName/'+name, headerOption);
      
  }
  getCoursesById(name:string): Observable<AssignCourse[]> {
    return this.http.get<AssignCourse[]>(this.dataUrl+'/getById/'+name, headerOption);
      
  }

  createAssignCourse(crs: AssignCourse): Observable<AssignCourse> {
    console.log("CreateEmployess");
    return this.http.post<AssignCourse>(this.dataUrl, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  deleteAssignCourse(id: number): Observable<AssignCourse> {
    return this.http.delete<AssignCourse>(this.dataUrl + '/' + id, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  updateAssignCourse(crs: AssignCourse): Observable<AssignCourse> {
    console.log("UpdateAssignCourse");
    return this.http.put<AssignCourse>(this.dataUrl + '/' + crs.assignid, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }

}
