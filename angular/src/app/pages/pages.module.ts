import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { NgApexchartsModule } from 'ng-apexcharts';
import { FlatpickrModule } from 'angularx-flatpickr';

import { UIModule } from '../shared/ui/ui.module';
import { PagesRoutingModule } from './pages-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';

import { WidgetModule } from '../shared/widgets/widget.module';
import { UiModule } from './ui/ui.module';
import { AppsModule } from './apps/apps.module';
import { OtherModule } from './other/other.module';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [DashboardComponent],
  imports: [
    CommonModule,
    FormsModule,
    NgbDropdownModule,
    NgApexchartsModule,
    FlatpickrModule.forRoot(),
    UIModule,
    WidgetModule,
    PagesRoutingModule,
    UiModule,
    AppsModule,
    OtherModule,
    HttpClientModule

  ]
})
export class PagesModule { }
