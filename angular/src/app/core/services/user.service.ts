import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { User } from '../models/auth.models';
import { Observable } from 'rxjs';
const headerOption = {
    headers: new HttpHeaders({ 'content-type': 'application/json' })
  };
@Injectable({ providedIn: 'root' })
export class UserProfileService {
    constructor(private http: HttpClient) { }
    dataUrl = 'http://localhost:8084/UniversityProtal/api/s1/users';
    
    getAllUser(): Observable<User[]> {
        return this.http.get<User[]>(this.dataUrl, headerOption);
          
      }
}