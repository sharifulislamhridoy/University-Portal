import { Component, OnInit } from '@angular/core';
import { FacultyService } from './Faculty.service';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { Faculty } from './Faculty.model';

@Component({
  selector: 'app-faculty-basic',
  templateUrl: './faculty.component.html',
  styleUrls: ['./faculty.component.scss']
})

/**
 * basic table component - handling the basic table with sidebar and content
 */
export class FacultyComponent implements OnInit {
  selectValue: string[];
  // bread crumb items
  breadCrumbItems: Array<{}>;


  alert: boolean = false;
  alertDelete: boolean = false;


  allFaculty: Faculty[];
  constructor(
    private facultyervice: FacultyService,
    private modalService: NgbModal,
    private router: Router
  )  { }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Tables', path: '' }, { label: 'Faculty', path: '', active: false }];
    this.selectValue = ['Andul Bari', 'MD. Maruf Hasan', 'Lenin Bhuram', 'Ashiqur Nobi', 'Dr. Obidullaha Hasan', 'Md. Rajib Hossiain ', 'Arizona', 'Colorado', 'Idaho', 'Montana', 'Nebraska', 'New Mexico', 'North Dakota', 'Utah', 'Wyoming', 'Alabama', 'Arkansas', 'Illinois', 'Iowa'];
    this.getAllFaculty();
    // this.facultyervice.refreshNeed.subscribe(() =>{
    //   this.getAllFaculty();
    // });
  }

  createOrUpdate(currentFaculty: Faculty) {
    if (currentFaculty.fact_id != null) {
      console.log("UpdateEmployess");
      this.updateFaculty(currentFaculty);
    } else {
      console.log("CreateEmployess");
      this.alert = true;
      this.createFaculty(currentFaculty);

    }
  }
  getAllFaculty() {
    this.facultyervice.getAllFaculty().subscribe(
      (data: Faculty[]) => {
        this.allFaculty = data;
        
      });
  }

  createFaculty(crs: Faculty) {
    this.facultyervice.createFaculty(crs).subscribe((result) => {
      this.alert = true;
    });
  }

  deleteFaculty(id: number) {
    this.facultyervice.deleteFaculty(id).subscribe(
      (data: Faculty) => {
        this.alertDelete = true;
        this.getAllFaculty();
      });

  }
  updateFaculty(crs: Faculty) {
    this.facultyervice.updateFaculty(crs).subscribe();
  }
  edit(crs: Faculty) {
    this.facultyervice.currentFaculty = Object.assign({}, crs)

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
