import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, Subject } from 'rxjs';


import { tap } from 'rxjs/operators';
import { Batch } from './batch.model';

const headerOption = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})

export class BatchService {
  dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/batch';
  currentBatch: Batch = new Batch();

  constructor(private http: HttpClient) {

  }

  private refreshNeeded = new Subject<void>();

  get refreshNeed(){
    return this.refreshNeeded;
  }

  getAllBatch(): Observable<Batch[]> {
    return this.http.get<Batch[]>(this.dataUrl, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }
  createBatch(crs: Batch): Observable<Batch> {
    console.log("CreateNotice");
    return this.http.post<Batch>(this.dataUrl, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  deleteBatch(id: number): Observable<Batch> {
    return this.http.delete<Batch>(this.dataUrl + '/' + id, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  updateBatch(crs: Batch): Observable<Batch> {
    console.log("UpdateNotice");
    return this.http.put<Batch>(this.dataUrl + '/' + crs.batchId, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }

}
