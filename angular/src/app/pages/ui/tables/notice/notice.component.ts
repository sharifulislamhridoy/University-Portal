import { Component, OnInit } from '@angular/core';
import { NoticeService } from './Notice.service';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { Notice } from './notice.model';

@Component({
  selector: 'app-Notice-basic',
  templateUrl: './Notice.component.html',
  styleUrls: ['./Notice.component.scss']
})

/**
 * basic table component - handling the basic table with sidebar and content
 */
export class NoticeComponent implements OnInit {
  selectValue: string[];
  // bread crumb items
  breadCrumbItems: Array<{}>;


  alert: boolean = false;
  alertDelete: boolean = false;


  allNotice: Notice[];
  constructor(
    private noticeervice: NoticeService,
    private modalService: NgbModal,
    private router: Router
  ) {
    $(document).ready( function () {
      $('#Notice-tabel').DataTable();
  } );
  this.getAllNotice();
   }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Tables', path: '' }, { label: 'Notice', path: '', active: false }];
    this.selectValue = ['Andul Bari', 'MD. Maruf Hasan', 'Lenin Bhuram', 'Ashiqur Nobi', 'Dr. Obidullaha Hasan', 'Md. Rajib Hossiain ', 'Arizona', 'Colorado', 'Idaho', 'Montana', 'Nebraska', 'New Mexico', 'North Dakota', 'Utah', 'Wyoming', 'Alabama', 'Arkansas', 'Illinois', 'Iowa'];
    this.getAllNotice();
  }

  createOrUpdate(currentNotice: Notice) {
    if (currentNotice.id != null) {
      console.log("UpdateEmployess");
      this.updateNotice(currentNotice);
    } else {
      console.log("CreateEmployess");
      this.alert = true;
      this.createNotice(currentNotice);

    }
  }
  getAllNotice() {
    this.noticeervice.getAllNotice().subscribe(
      (data: Notice[]) => {
        this.allNotice = data;
        console.log("Course Item :"+this.allNotice.length);
      });
  }

  createNotice(crs: Notice) {
    this.noticeervice.createNotice(crs).subscribe((result) => {
      this.alert = true;
    });
  }

  deleteNotice(id: number) {
    this.noticeervice.deleteNotice(id).subscribe(
      (data: Notice) => {
        this.alertDelete = true;
        this.getAllNotice();
      });

  }
  updateNotice(crs: Notice) {
    this.noticeervice.updateNotice(crs).subscribe();
  }
  edit(crs: Notice) {
    this.noticeervice.currentNotice = Object.assign({}, crs)

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
