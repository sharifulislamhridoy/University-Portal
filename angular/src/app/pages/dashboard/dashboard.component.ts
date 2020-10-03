import { Component, OnInit } from '@angular/core';

import { revenueAreaChart, targetsBarChart, salesDonutChart, ordersData } from './data';

import { ChartType, OrdersTable } from './dashboard.model';
import { CoursesbasicService } from '../ui/tables/Courses/Coursesbasic.service';
import { ProfessorsService } from '../ui/tables/profeesors/professors.service';
import { StudentsService } from '../ui/tables/students/students.service';
import { NoticeService } from '../ui/tables/notice/Notice.service';
import { AuthenticationService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})

/**
 * Dashboard component - handling dashboard with sidear and content
 */
export class DashboardComponent implements OnInit {
  totalStudent;
  totalProfessors;
  totalCourses;
  allNotice;
  access=true;
  constructor(
    private coursesService: CoursesbasicService,
    private professorsService: ProfessorsService,
    private studentsService: StudentsService,
    private toticeService : NoticeService,
    private authenticationService: AuthenticationService

  ) { }

  revenueAreaChart: ChartType;
  targetsBarChart: ChartType;
  salesDonutChart: ChartType;
  ordersData: OrdersTable[];

  ngOnInit() {

    /**
     * Fetches the data
     */
    this._fetchData();
    this.getAllCourses();
    this.getAllProfessors();
    this.getAllStudents();
    this.getAllNotice();
   this.checkAthuGard();
 
  }

  /**
   * fetches the dashboard value
   */
  private _fetchData() {
    this.revenueAreaChart = revenueAreaChart;
    this.targetsBarChart = targetsBarChart;
    this.salesDonutChart = salesDonutChart;
    this.ordersData = ordersData;
  }
  getAllCourses() {
    this.coursesService.getAllCourses().subscribe(
      (data) => {
        this.totalCourses = data.length;

      });
  }
  getAllProfessors() {
    this.professorsService.getAllProfessors().subscribe(
      (data) => {
        this.totalProfessors = data.length;

      });
  }
  getAllStudents() {
    this.studentsService.getAllStudents().subscribe(
      (data) => {
        this.totalStudent = data.length;
      });
  }
  getAllNotice() {
    this.toticeService.getAllNotice().subscribe(
      (data) => {
        this.allNotice = data;
      });
  }
   checkAthuGard(){
     if(this.authenticationService.user.lastName=='admin'){
       this.access=true;

     }else{
       this.access=false;
     }
   }
}