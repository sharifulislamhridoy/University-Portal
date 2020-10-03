import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmitCardComponent } from './AdmitCard.component';

describe('AdmitCardComponent', () => {
  let component: AdmitCardComponent;
  let fixture: ComponentFixture<AdmitCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdmitCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdmitCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
