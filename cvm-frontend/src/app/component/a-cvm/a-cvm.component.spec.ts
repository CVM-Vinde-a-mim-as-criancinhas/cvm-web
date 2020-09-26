import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ACvmComponent } from './a-cvm.component';

describe('ACvmComponent', () => {
  let component: ACvmComponent;
  let fixture: ComponentFixture<ACvmComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ACvmComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ACvmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
