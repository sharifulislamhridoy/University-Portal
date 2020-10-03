import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable, Subject } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Students } from './students';
const headerOption = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class StudentsService implements OnInit {
  dtOptions: DataTables.Settings = {};

  dataUrl = 'http://localhost:8084/UniversityProtal/api/s1/students';
  currentStudents: Students = new Students();


  private refreshNeeded = new Subject<void>();



  constructor(private http: HttpClient) {
  }

  get refreshNeed() {
    return this.refreshNeeded;
  }


  ngOnInit(): void {
    this.getAllStudents();

    console.log("serrvice is callting on ngOnInit")
  }

  getAllStudents(): Observable<Students[]> {
    return this.http.get<Students[]>(this.dataUrl, headerOption);

  }
  getOneStudents(id): Observable<Students[]> {
    return this.http.get<Students[]>(this.dataUrl + '/getByName/' + id, headerOption);

  }
  deleteStudents(id: number): Observable<Students> {
    return this.http.delete<Students>(this.dataUrl + '/' + id, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
        this.ngOnInit();
      })
    );
  }
  createStudents(emp: Students): Observable<Students> {
    console.log("CreateStudents");
    return this.http.post<Students>(this.dataUrl, emp, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
        this.ngOnInit();
      })
    );
  }
  updateStudents(std: Students): Observable<Students> {
    console.log("UpdateStudents");
    return this.http.put<Students>(this.dataUrl + '/' + std.studentsId, std, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }
}
