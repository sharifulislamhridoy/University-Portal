import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountHeadComponent } from './AccountHead.component';

describe('AccountHeadComponent', () => {
  let component: AccountHeadComponent;
  let fixture: ComponentFixture<AccountHeadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccountHeadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountHeadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
