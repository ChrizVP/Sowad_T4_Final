import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPersonalComponent } from './listarPersonal.component';

describe('ListarProductoComponent', () => {
  let component: ListarPersonalComponent;
  let fixture: ComponentFixture<ListarPersonalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarPersonalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarPersonalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
