import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { assignCourseComponent } from './assignCourse.component';



describe('assignCourseComponent', () => {
  let component: assignCourseComponent;
  let fixture: ComponentFixture<assignCourseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ assignCourseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(assignCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
