import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, Subject } from 'rxjs';


import { tap } from 'rxjs/operators';
import { AccountHead } from './accountHead.model';

const headerOption = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})

export class AccountHeadService {
  dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/accounthead';
  currentAccounthead: AccountHead = new AccountHead();

  constructor(private http: HttpClient) {

  }

  private refreshNeeded = new Subject<void>();

  get refreshNeed(){
    return this.refreshNeeded;
  }

  getAllAccounthead(): Observable<AccountHead[]> {
    return this.http.get<AccountHead[]>(this.dataUrl, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }
  createAccountHead(crs: AccountHead): Observable<AccountHead> {
    console.log("CreateEmployess");
    return this.http.post<AccountHead>(this.dataUrl, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  deleteAccountHead(id: number): Observable<AccountHead> {
    return this.http.delete<AccountHead>(this.dataUrl + '/' + id, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }
  getAllAccountHeadByName(name:string): Observable<AccountHead[]> {
    return this.http.get<AccountHead[]>(this.dataUrl+'/getByName/'+name, headerOption);
      
  }

  updateAccountHead(crs: AccountHead): Observable<AccountHead> {
    console.log("UpdateAccountHead");
    return this.http.put<AccountHead>(this.dataUrl + '/' + crs.code, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }

}
