import { MenuItem } from './menu.model';

export const TEACHER: MenuItem[] = [
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
        label: 'Apps',
        isTitle: true
    },
    {
        label: 'Event Management',
        icon: 'calendar',
        link: '/apps-calendar',
    },
    {
        label: 'Attandance',
        icon: 'users',
        subItems: [
            {
                label: 'All Students',
                // link: '/apps/project-list',
                link: '/ui/tables-students'
            },
            {
                label: 'Add Attandance',
                // link: '/apps/project-detail',
                link: '/other/pages-error-404'
            }
         
        ]
    },
    {
        label: 'Result Process',
        icon: 'users',
        subItems: [
            {
                label: 'Add Result',
                // link: '/apps/project-list',
                link: '/ui/tables-students'
            },
            {
                label: 'Show Result',
                // link: '/apps/project-detail',
                link: '/other/pages-error-404'
            },
    
        ]
    },
    // {
    //     label: 'Professors',
    //     icon: 'user',
    //     subItems: [
    //         {
    //             label: 'All Professors',
    //             // link: '/apps/email-inbox',
    //             link: '/ui/tables-professors'
    //         },
    //         {
    //             label: 'Add Professors',
    //             // link: '/apps/email-read'
    //             link: '/other/pages-error-404'
    //         },
    //         {
    //             label: 'Edit Professors',
    //             // link: '/apps/email-compose'
    //             link: '/other/pages-error-404'
    //         },
    //     ]
    // },
    // {
    //     label: 'Students',
    //     icon: 'users',
    //     subItems: [
    //         {
    //             label: 'All Students',
    //             // link: '/apps/project-list',
    //             link: '/ui/tables-students'
    //         },
    //         {
    //             label: 'Add Students',
    //             // link: '/apps/project-detail',
    //             link: '/other/pages-error-404'
    //         },
    //         {
    //             label: 'Edit Students',
    //             // link: '/apps/project-detail',
    //             link: '/other/pages-error-404'
    //         },
    //     ]
    // },
    // {
    //     label: 'Courses',
    //     icon: 'book-open',
    //     subItems: [
    //         {
    //             label: 'All Courses',
    //             // link: '/apps/task-list',
    //             link: '/ui/tables-courses-basic'
    //         },
    //         {
    //             label: 'Add Courses',
    //             // link: '/apps/task-list',
    //             link: '/ui/tables-advanced'
    //         },
    //         {
    //             label: 'Edit Course',
    //             // link: '/apps/task-board',
    //             link: '/ui/tables-courses-basic'
    //         },
    //     ]
    // },
    // {
    //     label: 'Others Activity',
    //     isTitle: true
    // },
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