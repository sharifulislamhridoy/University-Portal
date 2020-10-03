import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticationService } from '../../../core/services/auth.service';
import { SIDEBAR_WIDTH_CONDENSED } from '../../layout.model';
import { FakeBackendInterceptor } from 'src/app/core/helpers/fake-backend';

@Component({
  selector: 'app-leftsidebar',
  templateUrl: './leftsidebar.component.html',
  styleUrls: ['./leftsidebar.component.scss'],

})
export class LeftsidebarComponent implements OnInit {
  username;
  userRol;
  imgUrl;

  @Input() sidebarType: string;

  constructor(private router: Router, private authenticationService: AuthenticationService,

    ) { }

  ngOnInit() {
    this.getUserInformation();
  }

  /**
   * Is sidebar condensed?
   */
  isSidebarCondensed() {
    return this.sidebarType === SIDEBAR_WIDTH_CONDENSED;
  }

  /**
   * Logout the user
   */
  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/account/login'], { queryParams: { returnUrl: '/' } });
  }
  getUserInformation(){
    if(  this.authenticationService.user.lastName=='admin'){
      this.userRol='administrator';
      this.username=this.authenticationService.user.username;
      this.imgUrl="avatar-7.jpg";
      console.log("-----------------------------------------");
      console.log(this.authenticationService.user.username);
      console.log(this.authenticationService.user.firstName);
      console.log(this.authenticationService.user.lastName);
      console.log(this.authenticationService.user.email);
      console.log(this.authenticationService.user.token);
    }
    if(  this.authenticationService.user.lastName=='student'){
      console.log("-----------------------------------------");
      console.log(this.authenticationService.user.username);
      console.log(this.authenticationService.user.firstName);
      console.log(this.authenticationService.user.lastName);
      console.log(this.authenticationService.user.email);
      console.log(this.authenticationService.user.token);
     this.imgUrl="avatar-9.jpg";
      this.userRol='student';
      this.username=this.authenticationService.user.username;

    } 
    if( this.authenticationService.user.lastName=='teacher'){
      this.imgUrl="Screenshot(42).png";
      this.userRol='teacher';
      this.username=this.authenticationService.user.username;

    }
  }
}
