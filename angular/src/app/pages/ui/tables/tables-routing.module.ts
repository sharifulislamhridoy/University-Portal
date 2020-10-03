import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BasicComponent } from './basic/basic.component';

import { ProfessorsComponent } from './profeesors/professors.component';
import { CoursesBasicComponent } from './Courses/Coursesbasic.component';
import { AdvancedComponent } from './advanced/advanced.component';
import { StudentsComponent } from './students/students.component';
import { NoticeComponent } from './notice/notice.component';
import { SemesterComponent } from './semester/semester.component';
import { BatchComponent } from './batch/batch.component';
import { Classroutine } from './classRoutine/classRoutine.model';
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

const routes: Routes = [
    {
        path: 'tables-basic',
        component: BasicComponent
    },
    {
        path: 'tables-advanced',
        component: AdvancedComponent
    },
    {
        path: 'tables-professors',
        component: ProfessorsComponent
    },
    {
        path: 'tables-courses-basic',
        component: CoursesBasicComponent
    },
    {
        path: 'tables-students',
        component: StudentsComponent
    },
    {
        path: 'tables-notice',
        component: NoticeComponent
    },
    {
        path: 'tables-semester',
        component: SemesterComponent
    },
    {
        path: 'tables-batch',
        component: BatchComponent
    },
    {
        path: 'tables-classRoutine',
        component: ClassroutineComponent
    },
    {
        path: 'tables-Faculty',
        component: FacultyComponent
    },
    {
        path: 'tables-department',
        component: DepartmentComponent
    },
    {
        path: 'tables-assignCourse',
        component: assignCourseComponent
    },
    {
        path: 'tables-studentAccount',
        component: StudentaccountComponent
    },
    {
        path: 'tables-University',
        component: UniversityComponent
    },
    {
        path: 'tables-AccountHead',
        component: AccountHeadComponent
    },
    {
        path: 'tables-Payment',
        component: PaymentComponent
    },
    {
        path: 'tables-RsultShow',
        component: ResultComponent
    },
    {
        path: 'tables-ShowAttandance',
        component: ShowAttandanceComponent
    }
 
  

];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class TablesRoutingModule {}
