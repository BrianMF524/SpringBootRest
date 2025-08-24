import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MakersComponent } from './makers';

describe('Makers', () => {
  let component: MakersComponent;
  let fixture: ComponentFixture<MakersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MakersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MakersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
