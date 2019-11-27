import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditServicioComponent } from './editServicio.component';

describe('EditServicioComponent', () => {
  let component: EditServicioComponent;
  let fixture: ComponentFixture<EditServicioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditServicioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditServicioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
