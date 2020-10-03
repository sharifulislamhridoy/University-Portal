import { Component, OnInit, ViewChildren, QueryList } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { ProfessorsService } from './professors.service';
import { Professors } from './professors';
import { HttpClient } from '@angular/common/http';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { Courses } from '../Courses/courses.model';

class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}


@Component({
  selector: 'app-professors-table',
  templateUrl: './professors.component.html',
  styleUrls: ['./professors.component.scss'],
  providers: [ProfessorsService, DecimalPipe]
})

/**
 * Advanced table component - handling the advanced table with sidebar and content
 */
export class ProfessorsComponent implements OnInit {
  //Api courses
  coursesDatas;

  //image defult
  defultImage: string = '/assets/images/users/student-icon.png';
  fileToUplode = File = null;
  fileName;
  imgUrl:string='';

  allProfessors: Professors[];
  // bread crum data
  breadCrumbItems: Array<{}>;

  // Table data
  tableData;

  dtOptions: DataTables.Settings = {};
  proffessors;



  constructor(
    public professorsService: ProfessorsService,
    private modalService: NgbModal,
    private router: Router
  ) {

  }

  ngOnInit() {
    // tslint:disable-next-line: max-line-length
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Tables', path: '/' }, { label: 'Advanced', path: '/', active: true }];

    /**
     * fetch data
     */
    this._fetchData();
    this.getAllProfessors();
    this.professorsService.getAllProfessors().subscribe(
      (data: Professors[]) => {
        this.allProfessors = data;
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
    this.getAllProfessors();
    this.professorsService.refreshNeed.subscribe(() => {
      this.getAllProfessors();
    });
  }

  /**
   * Open extra large modal
   * @param extraLargeDataModal extra large modal data
   */
  extraLargeModal(extraLargeDataModal: any) {
    this.modalService.open(extraLargeDataModal, { size: 'xl' });
  }

  getAllProfessors() {
    this.professorsService.getAllProfessors().subscribe(
      (data: Professors[]) => {
        this.allProfessors = data;
      });

  }
  createOrUpdate(currentProfesors: Professors) {
    if (currentProfesors.id != null) {
      console.log("UpdateEmployess");
      this.updateEmployee(currentProfesors);
    } else {
      console.log("CreateEmployess");
      this.createEmployee(currentProfesors);
    }
  }
  createEmployee(pro: Professors) {
    console.log(pro.id);
    console.log(pro.name);
    console.log(pro.address);
    console.log(pro.birthDate);
    console.log(pro.department);
    console.log(pro.designation);
    console.log(pro.education);
    console.log(pro.email);
    console.log(pro.gender);
    console.log(pro.imgUrl);
    console.log(pro.joinDate);
    console.log(pro.phone);
    console.log(pro.password);
    this.professorsService.createProfessors(pro).subscribe();

  }
  updateEmployee(pro: Professors) {
    this.professorsService.updateProfessors(pro).subscribe();
  }
  clear() {
    this.professorsService.currentProfesors = new Professors();
  }

  deleteEmployee(id: number) {
    this.professorsService.deleteProfessors(id).subscribe(
      (data: Professors) => {
        this.getAllProfessors();
      });

  }
  edit(emp: Professors) {
    this.professorsService.currentProfesors = Object.assign({}, emp)

  }

  hadalFileInput(event: any) {

    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
      var prof = new Professors();
      reader.onload = (event: any) => {
        this.defultImage = event.target.result;
        prof.imgUrl = event.target.result;

      }
      reader.readAsDataURL(event.target.files[0]);
      console.log("file name : " + event.target.name);
      console.log("file result : " + event.target.result);
      console.log("file files : " + event.target.files);
      console.log("file target.files[0] : " + event.target.files[0]);
    }
  }


}

