import { Component, OnInit, ViewChildren, QueryList } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { Classroutine } from './classRoutine.model';
import { ClassroutineService } from './classRoutine.service';
import { CoursesbasicService } from '../Courses/Coursesbasic.service';
import { ProfessorsService } from '../profeesors/professors.service';
import { BatchService } from '../batch/batch.service';
import { Courses } from '../Courses/courses.model';
import { Batch } from '../batch/batch.model';
import { Professors } from '../profeesors/professors';
import { AuthenticationService } from 'src/app/core/services/auth.service';

class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}


@Component({
  selector: 'app-classroutine-table',
  templateUrl: './classroutine.component.html',
  styleUrls: ['./classroutine.component.scss'],
  providers: [ClassroutineService, DecimalPipe]
})

/**
 * Advanced table component - handling the advanced table with sidebar and content
 */
export class ClassroutineComponent implements OnInit {
  //Api courses
  coursesDatas;

  //image defult
  defultImage: string = '/assets/images/users/student-icon.png';
  fileToUplode = File = null;
  fileName;
  imgUrl:string='';

  allClassroutine: Classroutine[];
  // bread crum data
  breadCrumbItems: Array<{}>;

  // Table data
  tableData;

  dtOptions: DataTables.Settings = {};
  proffessors;

  day=['Saturday','Sunday','Monday', 'Tuesday', 'Wednesday','Thursday','Friday'];
  time=['Morning 09:30 AM','Morning 10:30 AM','Morning 11:30 AM','Morning 12:30 PM','Afternoon 2:30 PM','Afternoon 3:30 PM','Afternoon 4:30 PM', 'Evening 6:30PM', 'Evening 7:30PM', 'Evening 8:30PM'];
  courses;
  allBatch;
  allProfessors;
  auth;
  
  constructor(
    public classroutineService: ClassroutineService,
    private modalService: NgbModal,
    private coursesService: CoursesbasicService,
    private ProfessorsService: ProfessorsService,
    private authenticationService: AuthenticationService,
    private batchService: BatchService,

  ) {

  }

  ngOnInit() {
    // tslint:disable-next-line: max-line-length
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Tables', path: '/' }, { label: 'Advanced', path: '/', active: true }];

    /**
     * fetch data
     */
    this._fetchData();
    this.getAllClassroutine();
    this.classroutineService.getAllClassroutine().subscribe(
      (data: Classroutine[]) => {
        this.allClassroutine = data;
      });
      this.getAllClassroutine();
      this.getAllBatch();
      this.getAllTeacher();
      this.getAllcourses();
      this.authGart();

      this.classroutineService.refreshNeed.subscribe(() => {
        this.getAllClassroutine();
       
       
      });

  }

  /**
   * fetches the table value
   */
  _fetchData() {
    // this.tableData=tableData;
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

  getAllcourses() {
    this.coursesService.getAllCourses().subscribe(
      (data:Courses[]) => {
        this.courses = data;
      });
  
  }

  getAllClassroutine() {
    this.classroutineService.getAllClassroutine().subscribe(
      (data: Classroutine[]) => {
        this.allClassroutine = data;
      });
  
  }
  getAllBatch() {
    this.batchService.getAllBatch().subscribe(
      (data:Batch[]) => {
        this.allBatch = data;
      });
  
  }
  getAllTeacher() {
    this.ProfessorsService.getAllProfessors().subscribe(
      (data:Professors[]) => {
        this.allProfessors = data;
      });
  
  }

  createOrUpdate(currentClassroutine: Classroutine) {
    if (currentClassroutine.routineid != null) {
      console.log("UpdateEmployess");
      this.updateClassroutine(currentClassroutine);
    } else {
      console.log("CreateEmployess");
      this.createClassroutine(currentClassroutine);
    }
  }
  createClassroutine(pro: Classroutine) {

    this.classroutineService.createClassroutine(pro).subscribe();
  }
  updateClassroutine(pro: Classroutine) {
    this.classroutineService.updateClassroutine(pro).subscribe();
  }
  clear() {
    this.classroutineService.currentClassroutine = new Classroutine();
  }

  deleteClassroutine(id: number) {
    this.classroutineService.deleteClassroutine(id).subscribe(
      (data: Classroutine) => {
        this.getAllClassroutine();
      });

  }
  edit(emp: Classroutine) {
    this.classroutineService.currentClassroutine = Object.assign({}, emp)

  }

  authGart(){
    if(this.authenticationService.user.lastName=='admin'){
      this.auth=true;
    }else{
      this.auth=false;
    }
  }

}

