import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

import { WizardComponent as BaseWizardComponent } from 'angular-archwizard';
import { PaymentService } from '../../tables/payment/Payment.service';
import { Payment } from '../../tables/payment/Payment.model';
import { StudentaccountService } from '../../tables/studentaccount/studentaccount.service';
import { AssignCourse } from '../../tables/assignCourse/AssignCourse.model';

@Component({
  selector: 'app-wizard',
  templateUrl: './wizard.component.html',
  styleUrls: ['./wizard.component.scss']
})

/**
 * Form-wizard component - handling form-wizard with sidebar and content
 */
export class WizardComponent implements OnInit {
  // bread crumb items
  breadCrumbItems: Array<{}>;
  show_value=[];
  allPayment;
  Idvalue;
  getByCoursesId;
 
  // validation form
  validationForm: FormGroup;
  profileValidationForm: FormGroup;

  submit: boolean;
  submitForm: boolean;
  @ViewChild('wizardForm', { static: false }) wizardForm: BaseWizardComponent;

  constructor(public formBuilder: FormBuilder,
    private paymentService: PaymentService,
    private studentService:StudentaccountService) {

     }

  ngOnInit() {
    this.getByNameCourses();
    // tslint:disable-next-line: max-line-length
    this.breadCrumbItems = [{ label: 'Shreyu', path: '/' }, { label: 'Forms', path: '/' }, { label: 'Form Wizard', path: '/', active: true }];

    /**
     * form value validation
     */
    this.validationForm = this.formBuilder.group({
      id: ['', Validators.required],
      batchName: ['', Validators.required],
      departmentName: ['', Validators.required],
    });

    /**
     * form value validation
     */
    this.profileValidationForm = this.formBuilder.group({
      name: ['', Validators.required],
      surname: ['', Validators.required],
      email: ['', Validators.required],
    });

    this.submit = false;
    this.submitForm = false;

    this.getAllfaculty();
    
 
  }

  /**
   * Returns form
   */
  get form() {
    return this.validationForm.controls;
  }

  /**
   * Returns form
   */
  get profileForm() {
    return this.profileValidationForm.controls;
  }

  /**
   * Go to next step while form value is valid
   */
  formSubmit(currentpyament: Payment) {
    if (this.validationForm.valid) {
      this.wizardForm.goToNextStep();
      console.log(currentpyament);
    }
    this.submit = true;
  }

  /**
   * Go to next step while second form value is valid
   */
  profileFormSubmit(currentpyament: Payment) {
    currentpyament.id=this.Idvalue;
    if (this.profileValidationForm.valid) {
      this.wizardForm.goToNextStep();
      console.log(currentpyament);
      console.log(currentpyament.id);
      this.OnPressEnter();
    }
    this.submitForm = true;
  }

  OnPressEnter() {
    
  this.Idvalue =this.Idvalue+1;

    console.log(this.show_value);
    console.log(this.Idvalue);
  }

  getAllfaculty() {
    this.paymentService.getAllPayment().subscribe(
      (data: Payment[]) => {
        this.allPayment = data;
        this.Idvalue =this.allPayment.length+1;
      });
  }
  createOrUpdate(currentrPayment:Payment){



    currentrPayment.studentsId = this.getByCoursesId.studentsId;
    currentrPayment.name = this.getByCoursesId.departmentName;
    currentrPayment.facultyName = this.getByCoursesId.batchName;
    currentrPayment.departmentName = this.getByCoursesId.semesterName;
    currentrPayment.batchName = this.getByCoursesId.coursesName;
    currentrPayment.semesterName = "Spring";
    currentrPayment.type = "Payment";
    currentrPayment.datePayment = new Date;
    console.log(currentrPayment);

     this.createPayment(currentrPayment);

  }
  createPayment(crs: Payment) {

    this.paymentService.createPayment(crs).subscribe((result) => {
    });
  }
  getByNameCourses() {
    this.studentService.getCoursesById("123302236").subscribe(
      (data: AssignCourse[]) => {
        this.getByCoursesId = data[0];
        console.log(this.getByCoursesId);
      })

  }

}
