import { Injectable } from '@angular/core';
import { HttpRequest, HttpResponse, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { delay, mergeMap, materialize, dematerialize } from 'rxjs/operators';

import { User } from '../models/auth.models';
import { UserProfileService } from '../services/user.service';

@Injectable()
export class FakeBackendInterceptor implements HttpInterceptor {
    users: User[];
    roleName;
    userNmae;
    constructor(
        private userService: UserProfileService,
    ) {

    }
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        this.users = [
            { id: 1, username: 'Shariful Islam', email: 'admin@test.com', password: '123', firstName: 'Shariful Islam', lastName: 'admin' },
            { id: 2, username: 'Shariful Islam', email: 'admin@test.com', password: '123', firstName: 'Shariful Islam', lastName: 'admin' },
            { id: 3, username: 'Shanur Nahid', email: 'student@test.com', password: '123', firstName: 'Shanur Nahid', lastName: 'student' },
            { id: 4, username: 'Md. Maruf Hasan', email: 'teacher@test.com', password: '123', firstName: 'Md. Maruf Hasan', lastName: 'teacher' }

        ];

        const authHeader = request.headers.get('Authorization');
        const isLoggedIn = authHeader && authHeader.startsWith('Bearer fake-jwt-token');

        // wrap in delayed observable to simulate server api call
        return of(null).pipe(mergeMap(() => {

            // authenticate - public
            if (request.url.endsWith('/api/login') && request.method === 'POST') {
                const user = this.users.find(x => x.email == request.body.email && x.password == request.body.password);
                if (!user) {
                    return error('Email or password is incorrect');
                }
                if (user.lastName == 'admin') {
                    this.roleName = user.lastName;
                    this.userNmae = user.username;
                }
                if (user.lastName == 'student') {
                    this.roleName = user.lastName;
                    this.userNmae = user.username;
                }
                if (user.lastName == 'teacher') {
                    this.roleName = user.lastName;
                    this.userNmae = user.username;
                }
                return ok({
                    id: user.id,
                    username: user.username,
                    firstName: user.firstName,
                    lastName: user.lastName,
                    email: user.email,
                    token: `fake-jwt-token`
                });
            }

            // get all users
            if (request.url.endsWith('/api/users') && request.method === 'GET') {
                if (!isLoggedIn) { return unauthorised(); }
                return ok(this.users);
            }

            // pass through any requests not handled above
            return next.handle(request);
        }))
            .pipe(materialize())
            .pipe(delay(500))
            .pipe(dematerialize());

        // private helper functions

        function ok(body) {
            return of(new HttpResponse({ status: 200, body }));
        }

        function unauthorised() {
            return throwError({ status: 401, error: { message: 'Unauthorised' } });
        }

        function error(message) {
            return throwError({ status: 400, error: { message } });
        }
    }
    ngOnInit(): void {
        this.getAllUsers();

    }
    getAllUsers() {
        this.userService.getAllUser().subscribe(
            (data: User[]) => {
                // this.userss.push(data);
                this.users = data;
                console.log("this is in GetAlluser");
                console.log(this.users);
            });
    }
}

export let FakeBackendProvider = {
    // use fake backend in place of Http service for backend-less development
    provide: HTTP_INTERCEPTORS,
    useClass: FakeBackendInterceptor,
    multi: true
};
