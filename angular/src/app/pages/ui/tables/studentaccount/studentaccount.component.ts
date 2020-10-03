import { Component, OnInit } from '@angular/core';


import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { StudentaccountService } from './studentaccount.service';
import { Studentaccount } from './Studentaccount.model';
import { assignAssignCoursSeervice } from '../assignCourse/assignCourse.service';
import { AssignCourse } from '../assignCourse/AssignCourse.model';

@Component({
  selector: 'app-studentaccount-basic',
  templateUrl: './studentaccount.component.html',
  styleUrls: ['./studentaccount.component.scss']
})

/**
 * basic table component - handling the basic table with sidebar and content
 */
export class StudentaccountComponent implements OnInit {
  selectValue: string[];
  // bread crumb items
  breadCrumbItems: Array<{}>;


  alert: boolean = false;
  alertDelete: boolean = false;
  allstudentaccount;
  allAssingnCourses;
  newValCourses;
  getByCoursesName;
  
  constructor(
    private studentaccountService: StudentaccountService,
    private assignCourseService: assignAssignCoursSeervice,
    private modalService: NgbModal,
    private router: Router
  ) {
  //   $(document).ready( function () {
  //     $('#studentaccount-tabel').DataTable();
  // } );
  // this.getAllstudentaccount();
   }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Tables', path: '' }, { label: 'studentaccount', path: '', active: false }];
    this.selectValue = ['Andul Bari', 'MD. Maruf Hasan', 'Lenin Bhuram', 'Ashiqur Nobi', 'Dr. Obidullaha Hasan', 'Md. Rajib Hossiain ', 'Arizona', 'Colorado', 'Idaho', 'Montana', 'Nebraska', 'New Mexico', 'North Dakota', 'Utah', 'Wyoming', 'Alabama', 'Arkansas', 'Illinois', 'Iowa'];
    // this.getAllstudentaccount();
   this.getAllAssignCourses();
  //  this.getAllstudentaccount();
  this.getAllOnestudentaccount();
  }

  createOrUpdate(currentstudentaccount: Studentaccount) {
    if (currentstudentaccount.id != null) {
      console.log("UpdateEmployess");
      this.updatestudentaccount(currentstudentaccount);
    } else {
      console.log("CreateEmployess");
      currentstudentaccount.studentsId='123302236';
      currentstudentaccount.name='Shanur Nahid';
      currentstudentaccount.facultyName = this.getByCoursesName.facultyName;
      currentstudentaccount.departmentName = this.getByCoursesName.departmentName;
      currentstudentaccount.batchName = this.getByCoursesName.batchName;
      currentstudentaccount.semesterName = this.getByCoursesName.semesterName;
      currentstudentaccount.coursesName = this.getByCoursesName.coursesName;
      currentstudentaccount.courseCode = this.getByCoursesName.courseCode;
      currentstudentaccount.courseCradit = this.getByCoursesName.courseCradit;
      currentstudentaccount.coursePrice = this.getByCoursesName.coursePrice;
      currentstudentaccount.professorName = this.getByCoursesName.professorName;
      this.alert = true;
      this.createstudentaccount(currentstudentaccount);

    }
  }
  // getAllstudentaccount() {
  //   this.studentaccountService.getAllStudentaccount().subscribe(
  //     (data: Studentaccount[]) => {
  //       this.allstudentaccount = data;
  //       console.log("Course Item :"+this.allstudentaccount.length);
  //     });
  // }
  getAllOnestudentaccount() {
    this.studentaccountService.getCoursesOneStudentById("123302236").subscribe(
      (data: Studentaccount[]) => {
        this.allstudentaccount = data;
        console.log("Course Item :"+this.allstudentaccount.length);
      });
  }

  getAllAssignCourses() {
    this.assignCourseService.getAllAssignCourse().subscribe(
      (data: AssignCourse[]) => {
        this.allAssingnCourses = data;

      });
  }

  getByNameCourses() {
    this.assignCourseService.getCoursesByName(this.newValCourses).subscribe(
      (data: AssignCourse[]) => {
        this.getByCoursesName = data[0];
        console.log(this.getByCoursesName);
      })

  }



  createstudentaccount(crs: Studentaccount) {
    this.studentaccountService.createStudentaccount(crs).subscribe((result) => {
      this.alert = true;
    });
  }

  deletestudentaccount(id: number) {
    this.studentaccountService.deleteStudentaccount(id).subscribe(
      (data: Studentaccount) => {
        this.alertDelete = true;
        // this.getAllstudentaccount();
        this.getAllOnestudentaccount();
      });

  }
  updatestudentaccount(crs: Studentaccount) {
    this.studentaccountService.updateStudentaccount(crs).subscribe();
  }
  edit(crs: Studentaccount) {
    this.studentaccountService.currentStudentaccount = Object.assign({}, crs)

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
  oNchange(event) {
    this.newValCourses = event.target.value;
    console.log(this.newValCourses);
    this.getByNameCourses();

  }


}
