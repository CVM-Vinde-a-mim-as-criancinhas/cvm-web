import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AcolhimentoInstitucionalComponent } from './acolhimento-institucional.component';

describe('AcolhimentoInstitucionalComponent', () => {
  let component: AcolhimentoInstitucionalComponent;
  let fixture: ComponentFixture<AcolhimentoInstitucionalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AcolhimentoInstitucionalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AcolhimentoInstitucionalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
