import { Component, OnInit } from '@angular/core';
import { StudentsService } from '../../ui/tables/students/students.service';
import { Students } from '../../ui/tables/students/students';
import { assignAssignCoursSeervice } from '../../ui/tables/assignCourse/assignCourse.service';
import { AssignCourse } from '../../ui/tables/assignCourse/AssignCourse.model';
import { StudentaccountService } from '../../ui/tables/studentaccount/studentaccount.service';
import { PaymentComponent } from '../../ui/tables/payment/Payment.component';
import { PaymentService } from '../../ui/tables/payment/Payment.service';
import { Payment } from '../../ui/tables/payment/Payment.model';

@Component({
  selector: 'app-invoice',
  templateUrl: './admitCard.component.html',
  styleUrls: ['./admitCard.component.scss']
})
export class AdmitCardComponent implements OnInit {
  OneStudents;
  OneStudentsCourses;
  department ;
   // bread crumb items
   breadCrumbItems: Array<{}>;


   
  sum = 0;
  sumDue=2500;
  dueAmount=0;
  ststus=false;

   constructor(private studentservice:StudentsService,
    private saaignCourses: StudentaccountService,
    private paymentComponent:PaymentService,
    private studentaccount:StudentaccountService) { }

   ngOnInit() {
     this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Pages', path: '/' }, { label: 'Invoice', active: true }];
   this.getAllStudents();
    this.getAllStudentsCourses();
    this.getaccounSumCourse();
    this.getPaymentStudent();
 
   
    }

   getAllStudents() {
    this.studentservice.getOneStudents('123302236').subscribe(
      (data: Students[]) => {
        this.OneStudents = data[0];
        console.log(this.OneStudents.name);
      });
  }
  getAllStudentsCourses() {
    this.saaignCourses.getCoursesById('123302236').subscribe(
      (data: AssignCourse[]) => {
        this.OneStudentsCourses = data;
        this.department=data[0].departmentName;

        console.log(this.OneStudentsCourses)
      });

  }



  getPaymentStudent() {
    this.paymentComponent.getPaymentById("123302236").subscribe(
      (data: Payment[]) => {
        data.map(value => {        
          this.sum += value.basefee
          this.dueAmount +=value.basefee
          console.log(  this.sum );
          if(this.sum==this.sumDue){
              this.ststus=true;
               console.log(this.sum+"  //sum");
               console.log(this.sumDue+"  //sumDUe");
          }else{
            this.ststus=false;
          }
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
      }
    )

  }
  
}
