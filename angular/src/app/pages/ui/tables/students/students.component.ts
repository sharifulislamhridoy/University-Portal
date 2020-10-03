import { Component, OnInit, ViewChildren, QueryList } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { Students } from './students';
import { StudentsService } from './students.service';
import { AuthenticationService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-students-table',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.scss'],
  providers: [StudentsComponent, DecimalPipe]
})

/**
 * Advanced table component - handling the advanced table with sidebar and content
 */
export class StudentsComponent implements OnInit {


  //image defult
  defultImage: string = '/assets/images/users/student-icon.png';
  fileToUplode = File = null;
  fileName;
  imgUrl;
auther=true;
  allStudents: Students[];
  // bread crum data
  breadCrumbItems: Array<{}>;

  // Table data
  tableData;

  dtOptions: DataTables.Settings = {};
  proffessors;



  constructor(
    public studentsService: StudentsService,
    private modalService: NgbModal,
    private authenticationService: AuthenticationService

  ) {

  }

  ngOnInit() {
    // tslint:disable-next-line: max-line-length
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Tables', path: '/' }, { label: 'Advanced', path: '/', active: true }];

    /**
     * fetch data
     */
    this._fetchData();
    this.getAllStudents();
    this.authGard();
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
    this.getAllStudents();
    this.studentsService.refreshNeed.subscribe(() => {
      this.getAllStudents();
    });
  }

  /**
   * Open extra large modal
   * @param extraLargeDataModal extra large modal data
   */
  extraLargeModal(extraLargeDataModal: any) {
    this.modalService.open(extraLargeDataModal, { size: 'xl' });
  }

  getAllStudents() {
    this.studentsService.getAllStudents().subscribe(
      (data: Students[]) => {
        this.allStudents = data;
      });

  }
  createOrUpdate(currentProfesors: Students) {
    if (currentProfesors.studentsId != null) {
      console.log("UpdateEmployess");
      this.updateStudents(currentProfesors);
    } else {
      console.log("CreateEmployess");
      this.createStudents(currentProfesors);
    }
  }
  createStudents(pro: Students) {
    this.studentsService.createStudents(pro).subscribe();
    this.refresh();
  }
  updateStudents(pro: Students) {
    this.studentsService.updateStudents(pro).subscribe();
    this.refresh();
  }
  clear() {
    this.studentsService.currentStudents = new Students();
  }

  deleteStudents(id: number) {
    this.studentsService.deleteStudents(id).subscribe(
      (data: Students) => {
        this.getAllStudents();
        this.refresh();
      });

  }
  edit(emp: Students) {
    this.studentsService.currentStudents = Object.assign({}, emp)

  }

  hadalFileInput(event: any) {

    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
      var prof = new Students();
      reader.onload = (event: any) => {
        this.defultImage = event.target.result;
        prof.imgUrl = event.target.result;
      }
      reader.readAsDataURL(event.target.files[0]);
    }
  }

authGard(){
  if(this.authenticationService.user.lastName=='admin'){
    this.auther=true;

  }else{
    this.auther=false;
  }
}
refresh(){
  this.studentsService.refreshNeed.subscribe(()=>{
    this.getAllStudents();
  })


      // this.facultyervice.refreshNeed.subscribe(() =>{
    //   this.getAllFaculty();
    // });
}
}

