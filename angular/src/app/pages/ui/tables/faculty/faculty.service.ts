import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, Subject } from 'rxjs';


import { tap } from 'rxjs/operators';
import { Faculty } from './Faculty.model';

const headerOption = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})

export class FacultyService {
  dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/faculty';
  currentFaculty: Faculty = new Faculty();

  constructor(private http: HttpClient) {

  }

  private refreshNeeded = new Subject<void>();
  get refreshNeed() {
    return this.refreshNeeded;
  }

  getAllFaculty(): Observable<Faculty[]> {
    return this.http.get<Faculty[]>(this.dataUrl, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }
  createFaculty(crs: Faculty): Observable<Faculty> {
    console.log("CreateFaculty");
    return this.http.post<Faculty>(this.dataUrl, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  deleteFaculty(id: number): Observable<Faculty> {
    return this.http.delete<Faculty>(this.dataUrl + '/' + id, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  updateFaculty(crs: Faculty): Observable<Faculty> {
    console.log("UpdateFaculty");
    return this.http.put<Faculty>(this.dataUrl + '/' + crs.fact_id, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }

}
