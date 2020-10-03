import { NgModule } from '@angular/core';
import { CommonModule, DecimalPipe } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { NgbPaginationModule, NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap';

import { UIModule } from '../../../shared/ui/ui.module';

import { TablesRoutingModule } from './tables-routing.module';

import { BasicComponent } from './basic/basic.component';

import {ProfessorsComponent } from './profeesors/professors.component';

import { AdvancedSortableDirective } from './advanced/advanced-sortable.directive';
import { CoursesBasicComponent } from './Courses/Coursesbasic.component';
import { AdvancedComponent } from './advanced/advanced.component';
import { ProfessorsService } from './profeesors/professors.service';
import { NgSelectModule } from '@ng-select/ng-select';
import { StudentsComponent } from './students/students.component';
import { NoticeComponent } from './notice/notice.component';
import { SemesterComponent } from './semester/semester.component';
import { BatchComponent } from './batch/batch.component';
import { ClassroutineComponent } from './classRoutine/classRoutine.component';
import { FacultyComponent } from './faculty/Faculty.component';
import { DepartmentComponent } from './department/department.component';
import { assignCourseComponent } from './assignCourse/assignCourse.component';
import { StudentaccountComponent } from './studentaccount/studentaccount.component';
import { UniversityComponent } from './universityProfile/university.component';
import { AccountHeadComponent } from './accountHead/AccountHead.component';
import { PaymentComponent } from './payment/Payment.component';
import { ResultComponent } from './resultShow/resultShow.component';
import { ShowAttandanceComponent } from './showAttandance/showAttandance.component';



@NgModule({
  declarations: [
    BasicComponent,
    CoursesBasicComponent, 
    AdvancedComponent ,
    ProfessorsComponent, 
    AdvancedSortableDirective,
    StudentsComponent,
    NoticeComponent,
    SemesterComponent,
    BatchComponent,
    ClassroutineComponent,
    FacultyComponent,
    DepartmentComponent,
    assignCourseComponent,
    StudentaccountComponent,
    UniversityComponent,
    AccountHeadComponent,
    PaymentComponent,
    ResultComponent,
    ShowAttandanceComponent
   
  ],
  imports: [
    CommonModule,
    UIModule,
    TablesRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbPaginationModule,
    NgbTypeaheadModule,


 
    NgSelectModule,
  
 
  ],providers:[
    ProfessorsService,
    DecimalPipe
  ]
})
export class TablesModule { }
