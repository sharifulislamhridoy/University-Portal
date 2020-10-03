import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursesBasicComponent } from './Coursesbasic.component';

describe('CoursesBasicComponent', () => {
  let component: CoursesBasicComponent;
  let fixture: ComponentFixture<CoursesBasicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoursesBasicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursesBasicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
