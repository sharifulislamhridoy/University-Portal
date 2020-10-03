import { Component, OnInit } from '@angular/core';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { Semester } from './semester.model';
import { SemesterService } from './semester.service';
import { BatchService } from '../batch/batch.service';
import { FacultyService } from '../faculty/Faculty.service';
import { DepartmentService } from '../department/Department.service';
import { Department } from '../department/Department.model';
import { Batch } from '../batch/batch.model';
import { Faculty } from '../faculty/Faculty.model';

@Component({
  selector: 'app-Semester-basic',
  templateUrl: './semester.component.html',
  styleUrls: ['./semester.component.scss']
})

/**
 * basic table component - handling the basic table with sidebar and content
 */
export class SemesterComponent implements OnInit {
  selectValue: string[];
  // bread crumb items
  breadCrumbItems: Array<{}>;


  alert: boolean = false;
  alertDelete: boolean = false;


  allSemester: Semester[];
  allBatch;
  allFaculty;
  allDepartment;
  constructor(
    private semesterService: SemesterService,
    private modalService: NgbModal,
    private batchService:BatchService,
    private facultyService:FacultyService,
    private departmentService:DepartmentService,
    private router: Router
  ) {
  //   $(document).ready( function () {
  //     $('#Semester-tabel').DataTable();
  // } );   ,semesterId, semesterName, batchName, facultyName, departmentName
  this.getAllSemester();
   }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Tables', path: '' }, { label: 'Semester', path: '', active: false }];
    this.selectValue = ['Andul Bari', 'MD. Maruf Hasan', 'Lenin Bhuram', 'Ashiqur Nobi', 'Dr. Obidullaha Hasan', 'Md. Rajib Hossiain ', 'Arizona', 'Colorado', 'Idaho', 'Montana', 'Nebraska', 'New Mexico', 'North Dakota', 'Utah', 'Wyoming', 'Alabama', 'Arkansas', 'Illinois', 'Iowa'];
    this.getAllSemester();
    this.getAllFaculty();
    this.getAllBatch();
    this.getAllDepartment();
    // this.semesterService.refreshNeed.subscribe(() =>{
    //   this.getAllSemester();
    // });
    
  }

  createOrUpdate(currentSemester: Semester) {
    if (currentSemester.semesterId != null) {
      console.log("UpdateEmployess");
      this.updateSemester(currentSemester);
    } else {
      console.log("CreateEmployess");
      this.alert = true;
      this.createSemester(currentSemester);

    }
  }
  getAllSemester() {
    this.semesterService.getAllSemester().subscribe(
      (data: Semester[]) => {
        this.allSemester = data;
      });
  }

  getAllDepartment() {
    this.departmentService.getAllDepartment().subscribe(
      (data: Department[]) => {
        this.allDepartment = data;
      });
  }
  getAllBatch() {
    this.batchService.getAllBatch().subscribe(
      (data: Batch[]) => {
        this.allBatch = data;
      });
  }
  getAllFaculty() {
    this.facultyService.getAllFaculty().subscribe(
      (data: Faculty[]) => {
        this.allFaculty = data;
      });
  }

  createSemester(crs: Semester) {
    this.semesterService.createSemester(crs).subscribe((result) => {
      this.alert = true;
    });
  }

  deleteSemester(id: number) {
    this.semesterService.deleteSemester(id).subscribe(
      (data: Semester) => {
        this.alertDelete = true;
        this.getAllSemester();
      });

  }
  updateSemester(crs: Semester) {
    this.semesterService.updateSemester(crs).subscribe();
  }
  edit(crs: Semester) {
    this.semesterService.currentSemester = Object.assign({}, crs)

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



}
