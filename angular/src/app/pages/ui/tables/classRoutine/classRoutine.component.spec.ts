import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ClassroutineComponent } from './classRoutine.component';



describe('AdvancedComponent', () => {
  let component: ClassroutineComponent;
  let fixture: ComponentFixture<ClassroutineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClassroutineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClassroutineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
