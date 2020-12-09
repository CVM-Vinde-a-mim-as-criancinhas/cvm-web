import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComunidadeTerapeuticoComponent } from './comunidade-terapeutico.component';

describe('ComunidadeTerapeuticoComponent', () => {
  let component: ComunidadeTerapeuticoComponent;
  let fixture: ComponentFixture<ComunidadeTerapeuticoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComunidadeTerapeuticoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComunidadeTerapeuticoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
