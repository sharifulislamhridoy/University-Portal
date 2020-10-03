import { Component, OnInit, ViewChildren, QueryList } from '@angular/core';
import { DecimalPipe } from '@angular/common';
import { ShowAttandanceService } from './showAttandance.service';
import { ShowAttandance } from './showAttandance.model';





@Component({
  selector: 'app-Result-table',
  templateUrl: './showAttandance.component.html',
  styleUrls: ['./showAttandance.component.scss'],
  providers: [ShowAttandanceService, DecimalPipe]
})

/**
 * Advanced table component - handling the advanced table with sidebar and content
 */
export class ShowAttandanceComponent implements OnInit {



  allResult: ShowAttandance[];
  // bread crum data
  breadCrumbItems: Array<{}>;



  
  constructor(
    public ResultService: ShowAttandanceService,

  ) {

  }

  ngOnInit() {
    // tslint:disable-next-line: max-line-length
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Tables', path: '/' }, { label: 'Advanced', path: '/', active: true }];

    /**
     * fetch data
     */
  
      this.getAllResult();


  }

  

  




  getAllResult() {
    this.ResultService.getCoursesById("123302236").subscribe(
      (data: ShowAttandance[]) => {
        this.allResult = data;
      });
  
  }




 
  




 

}

