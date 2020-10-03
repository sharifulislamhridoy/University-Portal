import { Component, OnInit } from '@angular/core';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { AssignCourse } from './assignCourse.model';
import { assignAssignCoursSeervice } from './assignCourse.service';
import { CoursesbasicService } from '../Courses/Coursesbasic.service';
import { Courses } from '../Courses/courses.model';
import { Professors } from '../profeesors/professors';
import { ProfessorsService } from '../profeesors/professors.service';
import { event } from 'jquery';
import { StudentaccountService } from '../studentaccount/studentaccount.service';
import { Studentaccount } from '../studentaccount/Studentaccount.model';

@Component({
  selector: 'app-assignCourse-basic',
  templateUrl: './assignCourse.component.html',
  styleUrls: ['./assignCourse.component.scss']
})

/**
 * basic table component - handling the basic table with sidebar and content
 */
export class assignCourseComponent implements OnInit {
  selectValue: string[];
  // bread crumb items
  breadCrumbItems: Array<{}>;

  AllCourses;
  AllProfessors;
  getByCoursesName;
  newVal: string;
  newValCourses: string;
  getByProfessorsName;
  allAssingnCourses;
  allMyCourses;

  alert: boolean = false;
  alertDelete: boolean = false;


  allCourses: AssignCourse[];
  constructor(
    private courseservice: assignAssignCoursSeervice,
    private studentService: StudentaccountService,
    private courseAllService: CoursesbasicService,
    private allProfessorsService: ProfessorsService,
    private modalService: NgbModal,
    private router: Router
  ) {
    //   $(document).ready( function () {
    //     $('#courses-tabel').DataTable();
    // } );
    this.getAllCourses();
  }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Shreyu', path: 'http://localhost:4200/ui/tables-courses-basic' }, { label: 'Tables', path: '' }, { label: 'assignCourse', path: '', active: false }];
    this.selectValue = ['Andul Bari', 'MD. Maruf Hasan', 'Lenin Bhuram', 'Ashiqur Nobi', 'Dr. Obidullaha Hasan', 'Md. Rajib Hossiain ', 'Arizona', 'Colorado', 'Idaho', 'Montana', 'Nebraska', 'New Mexico', 'North Dakota', 'Utah', 'Wyoming', 'Alabama', 'Arkansas', 'Illinois', 'Iowa'];
    this.getAllCourses();
    this.getAllProfessor();
    this.getByNameProfessors();
    this.getCoursesById();
  }

  createOrUpdate(currentCourses: AssignCourse) {
    if (currentCourses.assignid != null) {
      console.log("UpdateEmployess");
      this.updateEmployee(currentCourses);
    } else {
      console.log("CreateEmployess");
      this.alert = true;

      currentCourses.facultyName = this.getByCoursesName.facultyName;
      currentCourses.departmentName = this.getByCoursesName.departmentName;
      currentCourses.batchName = this.getByCoursesName.batchName;
      currentCourses.semesterName = this.getByCoursesName.semesterName;
      currentCourses.coursesName = this.getByCoursesName.coursesName;
      currentCourses.courseCode = this.getByCoursesName.courseCode;
      currentCourses.courseCradit = this.getByCoursesName.courseCradit;
      currentCourses.coursePrice = this.getByCoursesName.coursePrice;
      currentCourses.professorName = this.getByProfessorsName.name;
      currentCourses.email = this.getByProfessorsName.email;
      currentCourses.designation = this.getByProfessorsName.designation;
      currentCourses.phone = this.getByProfessorsName.phone;
      this.createCourses(currentCourses);
    
    }
  }
  getAllAssignCourses() {
    this.courseservice.getAllAssignCourse().subscribe(
      (data: AssignCourse[]) => {
        this.allAssingnCourses = data;

      });
  }

  getCoursesById() {
    this.studentService.getCoursesOneStudentById("123302236").subscribe(
      (data: Studentaccount[]) => {
        this.allMyCourses = data;

      });
  
      
  }
  getAllCourses() {
    this.courseAllService.getAllCourses().subscribe(
      (data: Courses[]) => {
        this.AllCourses = data;

      });
  }
  getAllProfessor() {
    this.allProfessorsService.getAllProfessors().subscribe(
      (data: Professors[]) => {
        this.AllProfessors = data;

      });
  }

  createCourses(crs: AssignCourse) {

    this.courseservice.createAssignCourse(crs).subscribe((result) => {
      this.alert = true;


    });
  }

  deleteCourses(id: number) {
    this.courseservice.deleteAssignCourse(id).subscribe(
      (data: AssignCourse) => {
        this.alertDelete = true;
        this.getAllCourses();
      });

  }
  getByNameCourses() {
    this.courseAllService.getAllCoursesByName(this.newValCourses).subscribe(
      (data: Courses[]) => {
        this.getByCoursesName = data[0];
        console.log(this.getByCoursesName);
      })

  }




  getByNameProfessors() {
    this.allProfessorsService.getAllProfessorsByName(this.newVal).subscribe(

      (data: Professors[]) => {
        this.getByProfessorsName = data[0];

        console.log(this.getByProfessorsName);
      })

  }
  updateEmployee(crs: AssignCourse) {
    this.courseservice.updateAssignCourse(crs).subscribe();
  }
  edit(crs: AssignCourse) {
    this.courseservice.currentAssignCourse = Object.assign({}, crs)

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

  valuechange(event) {
    this.newVal = event.target.value;
    console.log(this.newVal);
    this.getByNameProfessors();

  }
  oNchange(event) {
    this.newValCourses = event.target.value;
    console.log(this.newValCourses);
    this.getByNameCourses();

  }

}
