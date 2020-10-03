import { Component, OnInit } from '@angular/core';
import { PaymentService } from './Payment.service';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { Payment } from './Payment.model';
import { StudentaccountService } from '../studentaccount/studentaccount.service';
import { Studentaccount } from '../studentaccount/Studentaccount.model';
import { AssignCourse } from '../assignCourse/AssignCourse.model';


@Component({
  selector: 'app-Payment-basic',
  templateUrl: './Payment.component.html',
  styleUrls: ['./Payment.component.scss']
})

/**
 * basic table component - handling the basic table with sidebar and content
 */
export class PaymentComponent implements OnInit {
  selectValue: string[];
  // bread crumb items
  breadCrumbItems: Array<{}>;

  studentPayment: Payment[];

  sum = 0;
  sumDue=2500;
  dueAmount;


  alert: boolean = false;
  alertDelete: boolean = false;


  allPayment: Payment[];
  constructor(
    private Paymentervice: PaymentService,
    private modalService: NgbModal,
    private router: Router,
    private studentaccount:StudentaccountService,
  ) {
    //   $(document).ready( function () {
    //     $('#Payment-tabel').DataTable();
    // } );
   

  }

  ngOnInit() {
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Tables', path: '' }, { label: 'Payment', path: '', active: false }];
    this.selectValue = ['Andul Bari', 'MD. Maruf Hasan', 'Lenin Bhuram', 'Ashiqur Nobi', 'Dr. Obidullaha Hasan', 'Md. Rajib Hossiain ', 'Arizona', 'Colorado', 'Idaho', 'Montana', 'Nebraska', 'New Mexico', 'North Dakota', 'Utah', 'Wyoming', 'Alabama', 'Arkansas', 'Illinois', 'Iowa'];
    this.getPaymentStudent();
    this.getaccounSumCourse();
    this.getAllPayment();

    this.dueAmount=this.sum-this.sumDue;
  }

  createOrUpdate(currentPayment: Payment) {
    if (currentPayment.id != null) {
     
      this.updatePayment(currentPayment);
    } else {
     
      this.alert = true;
      this.createPayment(currentPayment);

    }
  }
  getAllPayment() {
    this.Paymentervice.getAllPayment().subscribe(
      (data: Payment[]) => {
        this.allPayment = data;
        
      });

  }

  createPayment(crs: Payment) {
    this.Paymentervice.createPayment(crs).subscribe((result) => {
      this.alert = true;
      this.refresh()
    });


  }


  getPaymentStudent() {
    this.Paymentervice.getPaymentById("123302236").subscribe(
      (data: Payment[]) => {
        this.studentPayment=data;
        data.map(value => {        
          this.sum += value.basefee
          this.dueAmount +=value.basefee
        })

      
      }
    )

  }
  getaccounSumCourse() {
    this.studentaccount.getCoursesById("123302236").subscribe(
      (data: AssignCourse[]) => {
     
      data.map(value =>{
        this.sumDue += value.coursePrice
        this.dueAmount -=value.coursePrice
      })
      console.log(this.sumDue);
      }
    )

  }




  // getPaymentSum() {
  //   this.Paymentervice.getPaymentById("123302236").subscribe(
  //     (data: Payment[]) => {
       
  //     }
  //   )
  // }

  deletePayment(id: number) {
    this.Paymentervice.deletePayment(id).subscribe(
      (data: Payment) => {
        this.alertDelete = true;
        this.getAllPayment();
      });

  }
  updatePayment(crs: Payment) {
    this.Paymentervice.updatePayment(crs).subscribe();
  }
  edit(crs: Payment) {
    this.Paymentervice.currentPayment = Object.assign({}, crs)

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
refresh(){
  this.Paymentervice.refreshNeed.subscribe(() =>{
    this.getPaymentStudent();
    this.getaccounSumCourse();
    this.getAllPayment();
  });
}
  



}

