import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, Subject } from 'rxjs';


import { tap } from 'rxjs/operators';
import { Department } from './Department.model';

const headerOption = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})

export class DepartmentService {
  dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/department';
  currentDepartment: Department = new Department();

  constructor(private http: HttpClient) {

  }

  private refreshNeeded = new Subject<void>();
  get refreshNeed() {
    return this.refreshNeeded;
  }

  getAllDepartment(): Observable<Department[]> {
    return this.http.get<Department[]>(this.dataUrl, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }
  createDepartment(crs: Department): Observable<Department> {
    console.log("CreateDepartment");
    return this.http.post<Department>(this.dataUrl, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  deleteDepartment(id: number): Observable<Department> {
    return this.http.delete<Department>(this.dataUrl + '/' + id, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  updateDepartment(crs: Department): Observable<Department> {
    console.log("UpdateDepartment");
    return this.http.put<Department>(this.dataUrl + '/' + crs.dep_Id, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }

}
