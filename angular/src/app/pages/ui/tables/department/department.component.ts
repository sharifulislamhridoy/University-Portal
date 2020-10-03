import { Component, OnInit } from '@angular/core';
import { DepartmentService } from './Department.service';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { Department } from './Department.model';
import { FacultyService } from '../faculty/Faculty.service';
import { Faculty } from '../faculty/Faculty.model';

@Component({
  selector: 'app-department-basic',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.scss']
})

/**
 * basic table component - handling the basic table with sidebar and content
 */
export class DepartmentComponent implements OnInit {
  selectValue: string[];
  // bread crumb items
  breadCrumbItems: Array<{}>;


  alert: boolean = false;
  alertDelete: boolean = false;


  allDepartment: Department[];
  allfaculty;
  constructor(
    private departmentervice: DepartmentService,
    private facultyService:FacultyService,
    private modalService: NgbModal,
    private router: Router
  )  { }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Tables', path: '' }, { label: 'Department', path: '', active: false }];
    this.selectValue = ['Andul Bari', 'MD. Maruf Hasan', 'Lenin Bhuram', 'Ashiqur Nobi', 'Dr. Obidullaha Hasan', 'Md. Rajib Hossiain ', 'Arizona', 'Colorado', 'Idaho', 'Montana', 'Nebraska', 'New Mexico', 'North Dakota', 'Utah', 'Wyoming', 'Alabama', 'Arkansas', 'Illinois', 'Iowa'];
    this.getAllDepartment();
    // this.departmentervice.refreshNeed.subscribe(() =>{
    //   this.getAllDepartment();
    // });
    this.getAllFaculty();
  }

  createOrUpdate(currentDepartment: Department) {
    if (currentDepartment.dep_Id != null) {
      console.log("UpdateEmployess");
      this.updateDepartment(currentDepartment);
    } else {
      console.log("CreateEmployess");
      this.alert = true;
      this.createDepartment(currentDepartment);

    }
  }
  getAllDepartment() {
    this.departmentervice.getAllDepartment().subscribe(
      (data: Department[]) => {
        this.allDepartment = data;
      
      });
  }
  getAllFaculty() {
    this.facultyService.getAllFaculty().subscribe(
      (data: Faculty[]) => {
        this.allfaculty = data;
      
      });
  }



  createDepartment(crs: Department) {
    this.departmentervice.createDepartment(crs).subscribe((result) => {
      this.alert = true;
    });
  }

  deleteDepartment(id: number) {
    this.departmentervice.deleteDepartment(id).subscribe(
      (data: Department) => {
        this.alertDelete = true;
        this.getAllDepartment();
      });

  }
  updateDepartment(crs: Department) {
    this.departmentervice.updateDepartment(crs).subscribe();
  }
  edit(crs: Department) {
    this.departmentervice.currentDepartment = Object.assign({}, crs)

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
