import { Component, OnInit, ViewChildren, QueryList } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { University } from './university.model';
import { UniversityService } from './University.service';
import { AuthenticationService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-University-table',
  templateUrl: './University.component.html',
  styleUrls: ['./University.component.scss'],
  providers: [UniversityComponent, DecimalPipe]
})

/**
 * Advanced table component - handling the advanced table with sidebar and content
 */
export class UniversityComponent implements OnInit {


  //image defult
  defultImage: string = '/assets/images/users/student-icon.png';
  fileToUplode = File = null;
  fileName;
  imgUrl;
auther=true;
  allUniversity: University[];
  // bread crum data
  breadCrumbItems: Array<{}>;

  // Table data
  tableData;

  dtOptions: DataTables.Settings = {};
  proffessors;



  constructor(
    public UniversityService: UniversityService,
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
    this.getAllUniversity();
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
    this.getAllUniversity();
    this.UniversityService.refreshNeed.subscribe(() => {
      this.getAllUniversity();
    });
  }

  /**
   * Open extra large modal
   * @param extraLargeDataModal extra large modal data
   */
  extraLargeModal(extraLargeDataModal: any) {
    this.modalService.open(extraLargeDataModal, { size: 'xl' });
  }

  getAllUniversity() {
    this.UniversityService.getAllUniversity().subscribe(
      (data: University[]) => {
        this.allUniversity = data;
      });

  }
  createOrUpdate(currentProfesors: University) {
    if (currentProfesors.id != null) {
      console.log("UpdateEmployess");
      this.updateUniversity(currentProfesors);
    } else {
      console.log("CreateEmployess");
      this.createUniversity(currentProfesors);
    }
  }
  createUniversity(pro: University) {
    this.UniversityService.createUniversity(pro).subscribe();
    this.refresh();
  }
  updateUniversity(pro: University) {
    this.UniversityService.updateUniversity(pro).subscribe();
    this.refresh();
  }
  clear() {
    this.UniversityService.currentUniversity = new University();
  }

  deleteUniversity(id: number) {
    this.UniversityService.deleteUniversity(id).subscribe(
      (data: University) => {
        this.getAllUniversity();
        this.refresh();
      });

  }
  edit(emp: University) {
    this.UniversityService.currentUniversity = Object.assign({}, emp)

  }

  hadalFileInput(event: any) {

    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
      var prof = new University();
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

authGard(){
  if(this.authenticationService.user.lastName=='admin'){
    this.auther=true;

  }else{
    this.auther=false;
  }
}
refresh(){
  this.UniversityService.refreshNeed.subscribe(()=>{
    this.getAllUniversity();
  })


      // this.facultyervice.refreshNeed.subscribe(() =>{
    //   this.getAllFaculty();
    // });
}
}

