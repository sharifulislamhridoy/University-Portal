import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, Subject } from 'rxjs';


import { tap } from 'rxjs/operators';
import { Payment } from './Payment.model';

const headerOption = {
  headers: new HttpHeaders({ 'content-type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})

export class PaymentService {
  dataUrl = 'http://localhost:8084/UniversityProtal/api/v1/payment';
  currentPayment: Payment = new Payment();

  constructor(private http: HttpClient) {

  }

  private refreshNeeded = new Subject<void>();



get refreshNeed(){
  return this.refreshNeeded;
}

  getAllPayment(): Observable<Payment[]> {
    return this.http.get<Payment[]>(this.dataUrl, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }

  getPaymentById(name:string): Observable<Payment[]> {
    return this.http.get<Payment[]>(this.dataUrl+'/getById/'+name, headerOption);
      
  }
  createPayment(crs: Payment): Observable<Payment> {
    console.log("CreatePayment");
    return this.http.post<Payment>(this.dataUrl, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  deletePayment(id: number): Observable<Payment> {
    return this.http.delete<Payment>(this.dataUrl + '/' + id, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );
  }

  updatePayment(crs: Payment): Observable<Payment> {
    console.log("UpdatePayment");
    return this.http.put<Payment>(this.dataUrl + '/' + crs.id, crs, headerOption).pipe(
      tap(() => {
        this.refreshNeeded.next();
      })
    );

  }

}
