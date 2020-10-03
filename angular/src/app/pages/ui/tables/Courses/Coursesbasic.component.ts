import { Component, OnInit } from '@angular/core';
import { CoursesbasicService } from './Coursesbasic.service';
import { Courses } from './courses.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/core/services/auth.service';
import { assignAssignCoursSeervice } from '../assignCourse/assignCourse.service';
import { AssignCourse } from '../assignCourse/AssignCourse.model';

@Component({
  selector: 'app-courses-basic',
  templateUrl: './Coursesbasic.component.html',
  styleUrls: ['./Coursesbasic.component.scss']
})

/**
 * basic table component - handling the basic table with sidebar and content
 */
export class CoursesBasicComponent implements OnInit {
  selectValue: string[];
  // bread crumb items
  breadCrumbItems: Array<{}>;
  access;
  allAssignCourses;
  disablebutton =Array(25).fill(false);



  alert: boolean = false;
  alertDelete: boolean = false;


  allCourses: Courses[];
  constructor(
    private courseservice: CoursesbasicService,
    private assignCourseservice: assignAssignCoursSeervice,
    private modalService: NgbModal, 
    private authenticationService: AuthenticationService,
    private router: Router
  ) {

   
  }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Shreyu', path: 'http://localhost:4200/ui/tables-courses-basic' }, { label: 'Tables', path: '' }, { label: 'CoursesBasic', path: '', active: false }];
    this.selectValue = ['Andul Bari', 'MD. Maruf Hasan', 'Lenin Bhuram', 'Ashiqur Nobi', 'Dr. Obidullaha Hasan', 'Md. Rajib Hossiain ', 'Arizona', 'Colorado', 'Idaho', 'Montana', 'Nebraska', 'New Mexico', 'North Dakota', 'Utah', 'Wyoming', 'Alabama', 'Arkansas', 'Illinois', 'Iowa'];
    this.getAllCourses();
    this.getAllCoursesAssign();
    this.authGard();

    // $(document).ready(function () {
    //   $('#courses-tabel').DataTable();
    // });
  }

  createOrUpdate(currentCourses: Courses) {
    if (currentCourses.id != null) {
      console.log("UpdateEmployess");
      this.updateEmployee(currentCourses);
    } else {
      console.log("CreateEmployess");
      this.alert = true;
      this.createCourses(currentCourses);

    }
  }
  getAllCourses() {
    this.courseservice.getAllCourses().subscribe(
      (data: Courses[]) => {
        this.allCourses = data;
       
      });
  }
  getAllCoursesAssign() {
    this.assignCourseservice.getAllAssignCourse().subscribe(
      (data: AssignCourse[]) => {
        this.allAssignCourses = data;
       
      });
  }

  createCourses(crs: Courses) {
    this.courseservice.createCourses(crs).subscribe((result) => {
      this.alert = true;
      this.refrash();
    });
  }
  refrash() {
    this.courseservice.refreshNeed.subscribe(() => {
      this.getAllCourses();
    });
  }

  deleteCourses(id: number) {
    this.courseservice.deleteCourses(id).subscribe(
      (data: Courses) => {
        this.alertDelete = true;
        this.getAllCourses();
        this.refrash();
      });

  }
  updateEmployee(crs: Courses) {
    this.courseservice.updateCourses(crs).subscribe();
    this.refrash();
  }
  edit(crs: Courses) {
    this.courseservice.currentCourses = Object.assign({}, crs)
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
