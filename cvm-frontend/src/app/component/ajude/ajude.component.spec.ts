import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjudeComponent } from './ajude.component';

describe('AjudeComponent', () => {
  let component: AjudeComponent;
  let fixture: ComponentFixture<AjudeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjudeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjudeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
