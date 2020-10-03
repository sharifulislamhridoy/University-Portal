import { Component, OnInit } from '@angular/core';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { Batch } from './batch.model';
import { BatchService } from './batch.service';
import { FacultyService } from '../faculty/Faculty.service';
import { DepartmentService } from '../department/Department.service';
import { Faculty } from '../faculty/Faculty.model';
import { Department } from '../department/Department.model';

@Component({
  selector: 'app-Batch-basic',
  templateUrl: './batch.component.html',
  styleUrls: ['./batch.component.scss']
})

/**
 * basic table component - handling the basic table with sidebar and content
 */
export class BatchComponent implements OnInit {
  selectValue: string[];
  // bread crumb items
  breadCrumbItems: Array<{}>;


  alert: boolean = false;
  alertDelete: boolean = false;


  allBatch: Batch[];
  allFaculty;
  allDepartment;
  constructor(
    private batchService: BatchService,
    private facultyService: FacultyService,
    private departmentService: DepartmentService,
    private modalService: NgbModal,
    private router: Router
  ) {
    //   $(document).ready( function () {
    //     $('#Batch-tabel').DataTable();
    // } );
    this.getAllBatch();
  }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Tables', path: '' }, { label: 'Batch', path: '', active: false }];
    this.selectValue = ['Andul Bari', 'MD. Maruf Hasan', 'Lenin Bhuram', 'Ashiqur Nobi', 'Dr. Obidullaha Hasan', 'Md. Rajib Hossiain ', 'Arizona', 'Colorado', 'Idaho', 'Montana', 'Nebraska', 'New Mexico', 'North Dakota', 'Utah', 'Wyoming', 'Alabama', 'Arkansas', 'Illinois', 'Iowa'];
    this.getAllBatch();
    this.getAllfaculty();
    this.getAllDepartment();

    // this.batchService.refreshNeed.subscribe(() => {
    //   this.getAllBatch();
     
    // });


  }

  createOrUpdate(currentBatch: Batch) {
    if (currentBatch.batchId != null) {
      console.log("UpdateEmployess");
      this.updateBatch(currentBatch);
    } else {
      console.log("CreateEmployess");
      this.alert = true;
      this.createBatch(currentBatch);

    }
  }
  getAllBatch() {
    this.batchService.getAllBatch().subscribe(
      (data: Batch[]) => {
        this.allBatch = data;

      });
  }
  getAllfaculty() {
    this.facultyService.getAllFaculty().subscribe(
      (data: Faculty[]) => {
        this.allFaculty = data;

      });
  }
  getAllDepartment() {
    this.departmentService.getAllDepartment().subscribe(
      (data: Department[]) => {
        this.allDepartment = data;

      });
  }

  createBatch(crs: Batch) {
    this.batchService.createBatch(crs).subscribe((result) => {
      this.alert = true;
    });
  }

  deleteBatch(id: number) {
    this.batchService.deleteBatch(id).subscribe(
      (data: Batch) => {
        this.alertDelete = true;
        this.getAllBatch();
      });

  }
  updateBatch(crs: Batch) {
    this.batchService.updateBatch(crs).subscribe();
  }
  edit(crs: Batch) {
    this.batchService.currentBatch = Object.assign({}, crs)

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
