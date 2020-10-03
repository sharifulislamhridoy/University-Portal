import { MenuItem } from './menu.model';

export const MENU: MenuItem[] = [
    {
        label: 'Navigation',
        isTitle: true
    },
    {
        label: 'Dashboard',
        icon: 'home',
        link: '/',
        badge: {
            variant: 'success',
            text: '1',
        }
    },
    {
        label: 'Academic Calender',
        icon: 'calendar',
        link: '/apps-calendar',
    },
    {
        label: 'Academic',
        isTitle: true
    },
    {
        label: 'Academic Semester',
        icon: 'paperclip',
        subItems: [
            {
                label: 'University',
                // link: '/apps/email-inbox',
                link: '/ui/tables-University',
            },
            {
                label: 'Faculty',
                // link: '/apps/email-compose'
                link: '/ui/tables-Faculty',
            },{
                label: 'Department ',
                // link: '/apps/email-compose'
                link: '/ui/tables-department',
            },
            {
                label: 'Batch',
                // link: '/apps/email-read'
                link: '/ui/tables-batch',
            },
            {
                label: 'Semester',
                // link: '/apps/email-inbox',
                link: '/ui/tables-semester'
            },
            {
                label: 'Course',
                // link: '/apps/email-compose'
                link:  '/ui/tables-courses-basic'
            },
            {
                label: 'Assign Course',
                // link: '/apps/email-compose'
                link: '/ui/tables-assignCourse',
            }, {
                label: 'Class Routin',
                // link: '/apps/email-compose'
                link: '/ui/tables-classRoutine'
            },
            {
                label: 'Notice',
                link: '/ui/tables-notice'
            },
        ]
    },
    // {
    //     label: 'Exam',
    //     isTitle: true
    // },
    // {
    //     label: 'Exam',
    //     icon: 'pen-tool',
    //     subItems: [
    //         {
    //             label: 'Exam Routin',
    //             // link: '/apps/email-inbox',
    //             link: '/other/pages-error-404'
    //         },
    //         {
    //             label: 'Pring Admit Card',
    //             // link: '/apps/email-read'
    //             link: '/other/pages-AdmitCard',
    //         }
           
    //     ]
    // },
    {
        label: 'Account',
        isTitle: true
    },
    {
        label: 'Account Head',
        icon: 'credit-card',
        subItems: [
            {
                label: 'Account Create',
                // link: '/apps/email-inbox',
                link: '/ui/tables-AccountHead'
            },
            {
                label: 'Pring Admit Card',
                // link: '/apps/email-read'
                link: '/other/pages-AdmitCard',
            }
           
        ]
    },
    {
        label: 'Apps',
        isTitle: true
    },
    {
        label: 'Professors',
        icon: 'user',
        subItems: [
            {
                label: 'All Professors',
                // link: '/apps/email-inbox',
                link: '/ui/tables-professors'
            },
            {
                label: 'Add Professors',
                // link: '/apps/email-read'
                link: '/other/pages-error-404'
            },
            {
                label: 'Edit Professors',
                // link: '/apps/email-compose'
                link: '/other/pages-error-404'
            },
        ]
    },
    {
        label: 'Students',
        icon: 'users',
        subItems: [
            {
                label: 'All Students',
                // link: '/apps/project-list',
                link: '/ui/tables-students'
            },
            {
                label: 'Add Students',
                // link: '/apps/project-detail',
                link: '/other/pages-error-404'
            },
            {
                label: 'Edit Students',
                // link: '/apps/project-detail',
                link: '/other/pages-error-404'
            },
        ]
    },
    {
        label: 'Courses',
        icon: 'book-open',
        subItems: [
            {
                label: 'All Courses',
                // link: '/apps/task-list',
                link: '/ui/tables-courses-basic'
            },
            {
                label: 'Add Courses',
                // link: '/apps/task-list',
                link: '/ui/tables-advanced'
            },
            {
                label: 'Edit Course',
                // link: '/apps/task-board',
                link: '/ui/tables-courses-basic'
            },
        ]
    },
    // {
    //     label: 'Payment',
    //     icon: 'dollar-sign',
    //     subItems: [
    //         {
    //             label: 'Add Payment',
    //             // link: '/apps/email-inbox',
    //             link: '/ui/tables-Payment'
    //         },
    //         {
    //             label: 'Submit Payment',
    //             // link: '/apps/email-read'
    //             link:   '/ui/forms-wizard'
    //         },
    //         {
    //             label: 'Edit Professors',
    //             // link: '/apps/email-compose'
    //             link: '/other/pages-error-404'
    //         },
    //     ]
    // },
    // {
    //     label: 'Others Activity',
    //     isTitle: true
    // }
    
    // ,
    // {
    //     label: 'Service',
    //     icon: 'file-text',
    //     subItems: [
    //         {
    //             label: 'Notice',
    //             link: '/ui/tables-notice'
    //         },
    //         {
    //             label: 'Starter',
    //             link: '/other/pages-starter'
    //         },
    //         {
    //             label: 'Profile',
    //             link: '/other/pages-profile'
    //         },
    //         {
    //             label: 'Activity',
    //             link: '/other/pages-activity'
    //         },
    //         {
    //             label: 'Invoice',
    //             link: '/other/pages-invoice'
    //         },
    //         {
    //             label: 'Pricing',
    //             link: '/other/pages-pricing'
    //         },
    //         {
    //             label: 'Error 404',
    //             link: '/other/pages-error-404'
    //         },
    //         {
    //             label: 'Error 500',
    //             link: '/other/pages-error-500'
    //         },
    //     ]
    // },
    // {
    //     label: 'Custom',
    //     isTitle: true
    // },
    // {
    //     label: 'Pages',
    //     icon: 'file-text',
    //     subItems: [
    //         {
    //             label: 'Starter',
    //             link: '/other/pages-starter'
    //         },
    //         {
    //             label: 'Profile',
    //             link: '/other/pages-profile'
    //         },
    //         {
    //             label: 'Activity',
    //             link: '/other/pages-activity'
    //         },
    //         {
    //             label: 'Invoice',
    //             link: '/other/pages-invoice'
    //         },
    //         {
    //             label: 'Pricing',
    //             link: '/other/pages-pricing'
    //         },
    //         {
    //             label: 'Error 404',
    //             link: '/other/pages-error-404'
    //         },
    //         {
    //             label: 'Error 500',
    //             link: '/other/pages-error-500'
    //         },
    //     ]
    // },
    // {
    //     label: 'components',
    //     isTitle: true
    // },
    // {
    //     label: 'UI Elements',
    //     icon: 'package',
    //     subItems: [
    //         {
    //             label: 'Bootstrap UI',
    //             link: '/ui/bootstrap'
    //         },
    //         {
    //             label: 'Icons',
    //             link: '/ui/icons',
    //             subItems: [
    //                 {
    //                     label: 'Feather Icons',
    //                     link: '/ui/icon-feather'
    //                 },
    //                 {
    //                     label: 'Unicons Icons',
    //                     link: '/ui/icon-unicons'
    //                 },
    //             ]
    //         },
    //         {
    //             label: 'Widgets',
    //             link: '/ui/widgets'
    //         }
    //     ]
    // },
    // {
    //     label: 'Forms',
    //     link: '/ui/form',
    //     icon: 'file-text',
    //     subItems: [
    //         {
    //             label: 'Basic Elements',
    //             link: '/ui/forms-basic'
    //         },
    //         {
    //             label: 'Advanced',
    //             link: '/ui/forms-advanced'
    //         },
    //         {
    //             label: 'Validation',
    //             link: '/ui/forms-validation'
    //         },
    //         {
    //             label: 'Wizard',
    //             link: '/ui/forms-wizard'
    //         },
    //         {
    //             label: 'Editor',
    //             link: '/ui/forms-editor'
    //         },
    //         {
    //             label: 'File Uploads',
    //             link: '/ui/forms-uploads'
    //         },
    //     ]
    // },
    // {
    //     label: 'Charts',
    //     link: '/ui/charts',
    //     icon: 'pie-chart'
    // },
    // {
    //     label: 'Tables',
    //     link: '/ui/tables',
    //     icon: 'grid',
    //     subItems: [
    //         {
    //             label: 'Basic',
    //             link: '/ui/tables-basic'
    //         },
    //         {
    //             label: 'Advanced',
    //             link: '/ui/tables-advanced'
    //         },
    //         {
    //             label: 'Professors',
    //             link: '/ui/tables-professors'
    //         },
    //         {
    //             label: 'Courses',
    //             link: '/ui/tables-courses-basic'
    //         }
    //     ]
    // }
];
