import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EducacaoInfantilComponent } from './educacao-infantil.component';

describe('EducacaoInfantilComponent', () => {
  let component: EducacaoInfantilComponent;
  let fixture: ComponentFixture<EducacaoInfantilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EducacaoInfantilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EducacaoInfantilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
