import { Component, OnInit } from '@angular/core';
import { AccountHead } from './AccountHead.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/core/services/auth.service';
import { assignAssignCoursSeervice } from '../assignCourse/assignCourse.service';
import { AccountHeadService } from './accountHead.service';
import { AssignCourse } from '../assignCourse/AssignCourse.model';


@Component({
  selector: 'app-AccountHead-basic',
  templateUrl: './accountHead.component.html',
  styleUrls: ['./accountHead.component.scss']
})

/**
 * basic table component - handling the basic table with sidebar and content
 */
export class AccountHeadComponent implements OnInit {
  selectValue: string[];
  // bread crumb items
  breadCrumbItems: Array<{}>;
  access;
  allAssignAccountHead;
  disablebutton =Array(25).fill(false);



  alert: boolean = false;
  alertDelete: boolean = false;


  allAccountHead: AccountHead[];
  constructor(
    private accountHeadService: AccountHeadService,
    private assignAccountHeadervice: assignAssignCoursSeervice,
    private modalService: NgbModal, 
    private authenticationService: AuthenticationService,
    private router: Router
  ) {

   
  }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Shreyu', path: 'http://localhost:4200/ui/tables-AccountHead-basic' }, { label: 'Tables', path: '' }, { label: 'AccountHeadBasic', path: '', active: false }];
    this.selectValue = ['Andul Bari', 'MD. Maruf Hasan', 'Lenin Bhuram', 'Ashiqur Nobi', 'Dr. Obidullaha Hasan', 'Md. Rajib Hossiain ', 'Arizona', 'Colorado', 'Idaho', 'Montana', 'Nebraska', 'New Mexico', 'North Dakota', 'Utah', 'Wyoming', 'Alabama', 'Arkansas', 'Illinois', 'Iowa'];
    this.getAllAccountHead();
    this.getAllAccountHeadAssign();
    this.authGard();

    // $(document).ready(function () {
    //   $('#AccountHead-tabel').DataTable();
    // });
  }

  createOrUpdate(currentAccountHead: AccountHead) {
    if (currentAccountHead.code != null) {
      console.log("UpdateEmployess");
      this.updateEmployee(currentAccountHead);
    } else {
      console.log("CreateEmployess");
      this.alert = true;
      this.createAccountHead(currentAccountHead);

    }
  }
  getAllAccountHead() {
    this.accountHeadService.getAllAccounthead().subscribe(
      (data: AccountHead[]) => {
        this.allAccountHead = data;
       
      });
  }
  getAllAccountHeadAssign() {
    this.assignAccountHeadervice.getAllAssignCourse().subscribe(
      (data: AssignCourse[]) => {
        this.allAssignAccountHead = data;
       
      });
  }

  createAccountHead(crs: AccountHead) {
    this.accountHeadService.createAccountHead(crs).subscribe((result) => {
      this.alert = true;
      this.refrash();
    });
  }
  refrash() {
    this.accountHeadService.refreshNeed.subscribe(() => {
      this.getAllAccountHead();
    });
  }

  deleteAccountHead(id: number) {
    this.accountHeadService.deleteAccountHead(id).subscribe(
      (data: AccountHead) => {
        this.alertDelete = true;
        this.getAllAccountHead();
        this.refrash();
      });

  }
  updateEmployee(crs: AccountHead) {
    this.accountHeadService.updateAccountHead(crs).subscribe();
    this.refrash();
  }
  edit(crs: AccountHead) {
    this.accountHeadService.currentAccounthead = Object.assign({}, crs)
  }
  alertClose() {
    this.alert = false;
  }
  alertDeleteClose() {
    this.alertDelete = false;
  }

  /**
   * Open modal
   * @param content modal content
   */
  openModal(content: any) {
    this.modalService.open(content);
  }
  erroModal(errorModalData: any) {
    this.modalService.open(errorModalData, { centered: true });
  }

  /**
   * Open extra large modal
   * @param extraLargeDataModal extra large modal data
   */
  extraLargeModal(extraLargeDataModal: any) {
    this.modalService.open(extraLargeDataModal, { size: 'xl' });
  }
  /**
   * Open Large modal
   * @param largeDataModal large modal data
   */
  largeModal(largeDataModal: any) {
    this.modalService.open(largeDataModal, { size: 'lg' });
  }

authGard(){
  if(this.authenticationService.user.lastName=='admin'){
    this.access=true;

  }else{
    this.access=false;
  }
}
addtomainrecord(index) {
  this.disablebutton[index] = true;
 
}


}
