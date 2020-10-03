import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, Subject } from 'rxjs';


import { tap } from 'rxjs/operators';
import { Notice } from './notice.model';

const headerOption = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})

export class NoticeService {
  dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/notice';
  currentNotice: Notice = new Notice();

  constructor(private http: HttpClient) {

  }

  private refreshNeeded = new Subject<void>();

  getAllNotice(): Observable<Notice[]> {
    return this.http.get<Notice[]>(this.dataUrl, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }
  createNotice(crs: Notice): Observable<Notice> {
    console.log("CreateNotice");
    return this.http.post<Notice>(this.dataUrl, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  deleteNotice(id: number): Observable<Notice> {
    return this.http.delete<Notice>(this.dataUrl + '/' + id, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  updateNotice(crs: Notice): Observable<Notice> {
    console.log("UpdateNotice");
    return this.http.put<Notice>(this.dataUrl + '/' + crs.id, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }

}
